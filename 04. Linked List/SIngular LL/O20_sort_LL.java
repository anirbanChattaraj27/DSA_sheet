import java.util.Collections;
import java.util.LinkedList;

public class O20_sort_LL{
     
    public static void main(String[] args) {
    
        LinkedList<Integer> li = new LinkedList<Integer>();
    
        li.add(62);
        li.add(53);
        li.add(42);
        li.add(23);
        li.add(453);
    
        System.out.println("LinkedList before sorting: " + li.toString());
    
        Collections.sort(li); // sorting the elements of the linked list
    
        System.out.println("LinkedList after sorting in ascending order: " + li.toString());
    }
}