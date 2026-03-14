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

    // easy do this
    // reverse function
    public void reverseList() {
        if(head == null || head.next == null) {
            return;
        }

        // initializing 2 pointers
        Node previous = head;
        Node current = head.next;

        while(current != null) {
            // initializing 1 more pointer
            // i can also initailize the current node
            Node next = current.next;


            current.next = previous; // current node points to previos node
            // update
            previous = current;  // previos node mein save kar lenge current node ki value
            current = next;  // current node mein save kar lenge next node ki value
        }
        head.next = null;  // here we make head's next null
        head = previous;  // previous will be our new head  // bcz current node will be null so previous  will points on last node so this will become new head
    }

    public Node reverseList2(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static void main(String[] args) {
        O9_iteretive_reverse list = new O9_iteretive_reverse();

        list.addLast("abc");
        list.addLast("mno");
        list.addLast("pqr");
        list.addLast("xyz");
        list.display();

        list.reverseList();
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






