public class O5_delete_last {

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

    // delete last
    public void removeLast() {
        if(head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        size--;

        // if single node is there
        if(head.next == null) {
            head = null;  // make head null means delete head node
            return;
        }

        // 2 pointers pointing to head 
        Node secondLast = head;
        Node lastNode = head.next;

        // travarsing in LL
        // 1 pointer approch
        while(lastNode.next.next != null) { // untill last node's next is null
            lastNode = lastNode.next;
        }
        lastNode.next = null; // make secondLast's next null means delete last node

/*      // 2 pointers pointing to head 
        Node secondLast = head;
        Node lastNode = head.next;

        // travarsing in LL
        while(lastNode.next.next != null) { // untill last node's next is null
            // secondLast = secondLast.next;
            lastNode = lastNode.next;
        }
        lastNode.next = null; // make secondLast's next null means delete last node
*/
        /* 1 pointer approch */
        // Node secondLast = head;

        // // travarsing in LL
        // while(secondLast.next.next != null) { // untill last node's next is null
        //     secondLast = secondLast.next;
        // }
        // secondLast.next = null; // make secondLast's next null means delete last node

    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        O5_delete_last list = new O5_delete_last();

        list.addLast("abc");
        list.addLast("mno");
        list.addLast("xyz");
        list.removeLast();

        list.display();
    }
}
