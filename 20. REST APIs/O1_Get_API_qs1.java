/*
QS 1. Build a read-only Product Catalog REST API.
	1. GET /api/v1/products/{id} returns one product, or 404 if it doesn’t exist.
	2. GET /api/v1/products returns all products, with an optional category filter and pagination.
	3. Don’t expose DB fields directly. The response should show inStock (true/false) instead of the raw stock count.
    
    Use Controller, Service, Repository and DTO layers.
*/

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// ===== REQUEST FLOW (read this first) =====
// Client -> ProductController -> ProductService -> ProductRepository -> DB
// Data comes back as: Product (entity, DB row) -> ProductResponse (DTO) -> JSON to the client
// Each layer has ONE job: Controller = HTTP, Service = logic, Repository = DB queries.

@SpringBootApplication // ADDED: without this, Spring never starts and none of the classes below are picked up
public class O1_Get_API_qs1 {
    public static void main(String[] args) {
        SpringApplication.run(O1_Get_API_qs1.class, args); // ADDED: starts Spring, the embedded Tomcat server and creates all the beans
    }
}

@RestController // = @Controller + @ResponseBody: every return value is converted to JSON and sent as the HTTP response body
@RequestMapping("/api/v1/products") // base URL for every method in this class; "/api/v1" = version, "products" = plural noun
class ProductController {
    private final ProductService ps; // final = assigned once, can never be null or swapped later

    public ProductController(ProductService ps) { // why a constructor? Constructor injection: Spring sees the parameter and passes in the ProductService bean for you
        this.ps = ps;                             // benefits: field can be final, class is never half-built, easy to unit test (pass a mock), needs no @Autowired when there is one constructor
    }

    @GetMapping("/{id}") // FIXED: was @GetMpping (typo). Handles GET /api/v1/products/5. {id} is a placeholder filled by the URL
    public ProductResponse getById(@PathVariable long id) { // why ProductResponse? A DTO: we send only the fields the client should see, never the raw Product entity (see the class below)
        // @PathVariable = take the {id} part of the URL path (the "5" in /products/5) and put it in this parameter, converted to long
        return ps.getById(id); // FIXED: was ProductService.getById(id), which treats it as a static method. Call it on the injected object "ps"
    }

    @GetMapping // FIXED: this was missing. Without it, Spring does not expose this method as an endpoint: GET /api/v1/products
    public Page<ProductResponse> getAll( // Page<T> = one slice of results PLUS paging info: content (the list), totalElements, totalPages, number (page index), size, last
            @RequestParam(required = false) String category, // @RequestParam = take a value from the query string: ?category=MOBILE. required=false means it may be absent, then category is null. FIXED: renamed Category to category, the body used the lowercase name
            @PageableDefault(size = 10, sort = "id") Pageable pageable) { // FIXED: 'id' to "id" (Java strings use double quotes) and Pagable/Pageble spelling. Spring builds a Pageable from ?page=0&size=5&sort=price,desc. @PageableDefault is the fallback when the client sends nothing: page 0, 10 items, sorted by id
        return ps.getAll(category, pageable); // FIXED: the field is called ps, not "service"
    }
}

@Service // ADDED: tells Spring "create one object of this class and manage it", so it can be injected into the controller
class ProductService {
    private final ProductRepository repo; // FIXED: was "Private" (capital P). Java keywords are lowercase

    public ProductService(ProductRepository repo) { // Spring injects the repository implementation here. Spring Data creates it automatically
        this.repo = repo;
    }

    @Transactional(readOnly = true) // why? Opens a DB transaction/session for this method and closes it after. readOnly=true tells Hibernate "I will only read": skips dirty-checking, lets the DB optimise. A good habit for every GET
    public ProductResponse getById(long id) {
        Product p = repo.findById(id) // what is Product? The ENTITY: one Product object = one row of the "products" table. findById is NOT JPQL: it is a ready-made method from JpaRepository. Spring Data generates the SQL (select ... where id = ?) for you. JPQL is only when you write your own @Query("select p from Product p ...")
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id)); // findById returns Optional<Product> (maybe a row, maybe nothing). If empty, throw our exception. The global handler turns it into HTTP 404
        return toResponse(p); // FIXED: your method had no return statement, so it would not compile
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> getAll(String category, Pageable pageable) {
        Page<Product> page = (category == null || category.isBlank()) // no filter given (null or blank) -> return everything
                ? repo.findAll(pageable)                               // findAll(Pageable) comes free from JpaRepository: select ... limit ? offset ?
                : repo.findByCategoryIgnoreCase(category, pageable);  // filter given -> our own method from the repository below
        return page.map(this::toResponse); // Page.map converts each Product into a ProductResponse and keeps the paging info (totalPages etc.)
    }

    private ProductResponse toResponse(Product p) { // ADDED: your code used this::toResponse but never defined it. This is the Entity -> DTO conversion
        return new ProductResponse(p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getStock() > 0); // computed field: client gets inStock (true/false), not the raw stock count
    }
}

interface ProductRepository extends JpaRepository<Product, Long> { // what is this? A Spring Data JPA repository. <Product, Long> = "this repository handles the Product entity, whose id type is Long". NOTE: it is an interface and has no code
    // why No implementation, bcz--> Because Spring Data JPA automatically provides an implementation at runtime. At startup Spring generates one that already has save(), findById(), findAll(), deleteById(), count(), existsById() ... 

    // Spring generates the query from the method name: find + By + Category + IgnoreCase
    // = select * from products where upper(category) = upper(?)   (the Pageable adds limit/offset and order by)
    Page<Product> findByCategoryIgnoreCase(String category, Pageable pageable); // the field name in the method must match the entity field exactly: category
    
}

record ProductResponse(Long id, String name, String category, BigDecimal price, boolean inStock) {
    // FIXED: your version wrapped this record inside "class ProductResponse", which made the type ProductResponse.ProductResponse and broke every other reference. Make it a top-level record instead
    // why this class? A DTO (Data Transfer Object) = the shape of the JSON the client receives
    //  1) hides internals: no raw stock number, no fields you do not want to expose (e.g. a password on a User)
    //  2) lets you change the database without breaking the API contract
    //  3) avoids lazy-loading and infinite-recursion problems when serialising entities
    // "record" = a short way to write an immutable class: constructor, getters (id(), name()...), equals, hashCode and toString are generated
}

@Entity // marks this class as mapped to a database table (JPA/Hibernate manages it). FIXED: your version had "class Product { class Product {...} }", a class nested inside a class of the same name. Keep ONE top-level class
@Table(name = "products") // table name in the DB. Without it the default would be "product"
class Product {

    @Id // primary key column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the DB auto-increments the id (auto_increment / identity column), so you never set it yourself
    private Long id;

    @Column(nullable = false) // column is NOT NULL in the table
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal price; // BigDecimal for money, never double (double has rounding errors)

    private int stock;

    protected Product() {} // JPA/Hibernate creates objects by reflection and needs a no-arg constructor. "protected" stops normal code from calling it

    // getters only: a read-only API needs no setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }
}

class ResourceNotFoundException extends RuntimeException { // ADDED: your code threw this but never defined it. Unchecked (RuntimeException) so no "throws" clause is needed
    public ResourceNotFoundException(String message) { super(message); }
}

// STILL NEEDED for a real 404: a @RestControllerAdvice class with @ExceptionHandler(ResourceNotFoundException.class)
// returning ResponseEntity.status(404). Without it, Spring answers 500 instead of 404. See the GET template page, Step 2.