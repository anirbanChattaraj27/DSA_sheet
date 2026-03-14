

public class O13_nTh_node_from_end_of_LL {

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

    // function for nth node from end of ll
    public Node getNthNodeFromEnd(int n) {
		if(head == null) {
			return null;
		}

		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}

        // crating 2 pointer which will points on head
		Node mainPtr = head;  // mainPtr starts from head
		Node refPtr = head;  // refPtr starts from head

        while(n -- > 0 ){
            if(refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPtr = refPtr.next;
        }

        // here we move both pointer refPtr and mainPtr 
		while(refPtr != null) {  // refPtr moves until it reaches null
			refPtr = refPtr.next;  // move refPtr to the next node
			mainPtr = mainPtr.next;  // move mainPtr to the next node // main pointer was in head node here move the the next node
		}
        // when above loop will ends refPtr becomes null and mainPtr will reach Nth position
		return mainPtr;
	}

    public static void main(String[] args) {
        O13_nTh_node_from_end_of_LL list = new O13_nTh_node_from_end_of_LL();

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
        Node nNode = list.getNthNodeFromEnd(3);
        System.out.println("node is: " + nNode.data);

        // 2nd way to print
        // System.out.println(list.getNthNodeFromEnd(2).data);
    }
}

