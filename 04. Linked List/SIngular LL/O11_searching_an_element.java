
public class O11_searching_an_element {

    Node head;  // here we create head
    private int size;

    // creating node
    public class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // diaply LL 
    public void display(){
        if (head == null){
            System.out.println("Empty list");
            return;
        }

        Node lastNode = head;
        while (lastNode != null) {
            System.out.print(lastNode.data + " --> ");
            lastNode = lastNode.next;
        }
        System.out.println("NULL");
    }

    // addding at last of the node
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // searching
    public boolean find(int searchKey) {
        if(head == null) {
            return false;
        }
    
        Node current = head;
        while(current != null) {
            if(current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        O11_searching_an_element list = new O11_searching_an_element();

        list.addLast(5);
        list.addLast(56);
        list.addLast(78);
        list.addLast(12);
        list.display();

        System.out.println(list.find(5));
    }
}


