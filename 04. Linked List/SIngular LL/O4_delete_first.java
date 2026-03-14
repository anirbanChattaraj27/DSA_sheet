public class O4_delete_first {

    Node head;  // here we create head
    private int size;

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

    // delete 1st element
    public void removeFirst() {
        // if head is null
        if(head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        // if head is not null then move head pointer to next node
        head = this.head.next; // if i wish i can not use "this"
        size--;
    }

    public static void main(String[] args) {
        O4_delete_first list = new O4_delete_first();

        list.addLast("abc");
        list.addLast("xyz");
        list.removeFirst();

        list.display();
    }
}