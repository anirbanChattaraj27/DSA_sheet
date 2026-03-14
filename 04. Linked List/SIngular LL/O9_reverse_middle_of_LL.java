public class O9_reverse_middle_of_LL {

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

    // reverse function
    public Node reverseBetween(Node head, int left, int right) { // node head should be here 
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node current = head;  // current starts from head
        Node prev = null;   // prev starts from null
        for (int i = 0; current != null && i < left - 1; i++) {  // i starts from head and goes upto left-1 means if left is 2 means loop starts from 3 so 3-1=2 upto 2nd node i will continue
            prev = current;  // move prev to the current position
            current = current.next;  // move  current to next node
        }

        Node last = prev;
        Node newEnd = current;

        // reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }        



    public static void main(String[] args) {
        O9_reverse_middle_of_LL list = new O9_reverse_middle_of_LL();

        list.addLast("abc");
        list.addLast("mno");
        list.addLast("pqr");
        list.addLast("xyz");
        list.display();

        // list.reverseBetween(1, 3);
        list.display();

    }
}

