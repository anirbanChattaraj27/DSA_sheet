public class O15_insert_in_sorted_LL {

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

    // insert in sorted list
    public Node insertInSortedList(int value) {
		Node newNode = new Node(value);

		if(head == null) {
			return newNode;
		}

		Node current = head; // current pointer points on head
		Node temp = null;  // temp pointer points to null

		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}

		newNode.next = current;
		temp.next = newNode;
		return head;
	} 

    public static void main(String[] args) {
        O15_insert_in_sorted_LL list = new O15_insert_in_sorted_LL();

        list.addLast(2);
        list.addLast(5);
        list.addLast(12);
        list.addLast(78);
        list.addLast(82);
        list.addLast(172);
        list.addLast(282);
        list.display();

        // 1st way to print
        list.insertInSortedList(45);
        list.display();
    }
}