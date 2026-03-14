// to remove a loop, i need a pointer which is previous of slowPtr when slowPtr meets starting position of looop means from where loop is starting then previos ptr of slowPtr will be just before the position of index of sarting loop point then from there make previos pointer as null so no loops will be there


public class O19_remove_loop {

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

    // remove loop function
    public void removeLoop() {
		Node fastPtr = head;
		Node slowPtr = head;

		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if(fastPtr == slowPtr) {
				remove(slowPtr);
				return;
			}
		}
	}

	private void remove(Node slowPtr) {
		Node temp = head;
		while(temp.next != slowPtr.next){
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

    // creating loop
    public void createALoopInLinkedList() {
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}

    public static void main(String[] args) {
		O19_remove_loop list = new O19_remove_loop();
		list.createALoopInLinkedList();
		list.removeLoop();
        list.display();
    }
}
