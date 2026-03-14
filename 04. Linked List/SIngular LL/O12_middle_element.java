


public class O12_middle_element {

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
    
    // find middle of LL
    public Node getMiddleNode() {
        if(head == null) {
            return null;
        }

        // initialize 2 pointer 1 pointer goeas 1 by 1 node and 1 pointer goes by nodes means double speed
        Node slowPtr = head;
        Node fastPtr = head;
    
        while(fastPtr != null && fastPtr.next != null) {  // when fastPtr will not null means LL has even node then execute OR when fastPtr's next will not null means LL has odd nodes then execute following codes
            slowPtr = slowPtr.next;  // increase by 1 node
            fastPtr = fastPtr.next.next; // increase by 2 nodes
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        O12_middle_element list = new O12_middle_element();

        list.addLast(5);
        list.addLast(56);
        list.addLast(78);
        list.addLast(12);
        list.addLast(182);
        list.addLast(172);
        list.addLast(2);
        list.addLast(52);
        list.addLast(82);
        list.display();

        // 1st way to print
        Node midNode = list.getMiddleNode();
        System.out.println("middle node is: " + midNode.data);

        // 2nd way to print
        System.out.println(list.getMiddleNode().data);
    }
}


