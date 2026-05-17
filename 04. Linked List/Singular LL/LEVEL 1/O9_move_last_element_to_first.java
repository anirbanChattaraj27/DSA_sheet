public class O9_move_last_element_to_first {

    Node head;

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node lastNode = head;
        while (lastNode != null) {
            System.out.print(lastNode.data + "->");
            lastNode = lastNode.next;
        }
        System.out.println("NULL");
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Fixed: Removed parameters to directly modify the instance 'head'
    public void moveLastToFirst() {
        // Edge case: Empty list or single node list
        if (head == null || head.next == null) {
            return;
        }

        Node first = head.next;
        Node second = head;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = null; // Fixed: Disconnect the last node from the list
        first.next = head; // Link the last node to the old head
        head = first; // Fixed: Update the head of the class to the last node
    }

    public static void main(String[] args) {
        O9_move_last_element_to_first list = new O9_move_last_element_to_first();

        list.addFirst("abc");
        list.addFirst("mnp");
        list.addFirst("pqr");
        list.addFirst("xyz");

        System.out.println("Original List:");
        list.display();

        list.moveLastToFirst(); // Fixed: Call the updated method

        System.out.println("\nModified List:");
        list.display();
    }
}
