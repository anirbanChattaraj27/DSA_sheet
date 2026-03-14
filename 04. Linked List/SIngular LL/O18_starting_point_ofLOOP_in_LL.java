public class O18_starting_point_ofLOOP_in_LL {
    
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

    // checking loop is there or not
    public Node containsLoop() {
		Node fastPtr = head;
		Node slowPtr = head;
		Node entry = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr) {
				while(slowPtr != entry){
                    slowPtr = slowPtr.next;
                    entry = entry.next;
                }
                return entry;
			}
		}
		return null;
	}

    // creating loop
    public void createALoopInLinkedList() {
		Node first =  new Node(1);
		Node second = new Node(2);
		Node third =  new Node(3);
		Node fourth = new Node(4);
		Node fifth =  new Node(5);
		Node sixth =  new Node(6);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}

    public static void main(String[] args) {
        O18_starting_point_ofLOOP_in_LL list = new O18_starting_point_ofLOOP_in_LL();
        
        list.createALoopInLinkedList();
        System.out.println(list.containsLoop());
    }
}




