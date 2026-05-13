public class O9_iteretive_reverse {

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

    public ListNode reverseList(ListNode head) {
    ListNode prev = null; // Start prev as null to correctly set the new tail's next pointer
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next; // Save the next node

        curr.next = prev;          // Reverse the link
        
        // move prev and curr to forward
        prev = curr;               // prev points to curr
        curr = next;               // curr points to next
    }

    return prev; // prev will point to the new head at the end
}

    public static void main(String[] args) {
        O9_iteretive_reverse list = new O9_iteretive_reverse();

        list.addLast("abc");
        list.addLast("mno");
        list.addLast("pqr");
        list.addLast("xyz");
        list.display();

        // list.reverseList();
        list.display();
    }
}


/* this reverse function is quite good try to use this
        *******reverse function******** */
//     public Node reverse(Node head) {
//         if(head == null) {
//             return null;
//     }

//     Node current = head;
//     Node previous = null;
//     Node next = null;

//     while(current != null) {
//         next = current.next;
//         current.next = previous;
//         previous = current;
//         current = next;
//     }
//     return previous;
// }






