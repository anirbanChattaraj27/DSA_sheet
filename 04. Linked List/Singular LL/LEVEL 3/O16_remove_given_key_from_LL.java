
public class O16_remove_given_key_from_LL {

    Node head; // here we create head
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
    public void display() {
        if (head == null) {
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

    // remove given key
    public void deleteNode(int key) {
        if (head == null) {
            return;
        }
 
        // Delete the head node
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;

        // Check the next node before deleting it
        while (current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public static void main(String[] args) {
        O16_remove_given_key_from_LL list = new O16_remove_given_key_from_LL();

        list.addLast(5);
        list.addLast(8);
        list.addLast(10);
        list.addLast(11);
        list.addLast(18);
        list.display();

        list.deleteNode(11);
        list.display();
    }
}
