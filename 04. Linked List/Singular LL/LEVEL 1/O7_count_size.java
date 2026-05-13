

public class O7_count_size {

    Node head;  // here we create head
    private int size;

    O7_count_size(){
        this.size = 0;
    }

    // creating node
    public class Node {
        String data;
        Node next;
        
        Node(String data) {
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
    public void addLast(String data) {
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

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        O7_count_size list = new O7_count_size();

        list.addLast("abc");
        list.addLast("xyz");

        list.display();

        System.out.println(list.getSize());
    }
}