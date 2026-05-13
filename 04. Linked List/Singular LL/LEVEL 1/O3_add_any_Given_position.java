public class O3_add_any_Given_position {

    Node head;  // here we create head
    int size;

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

    // add at any given position
    public void addInMiddle(int index, String data) {
        if(index > size || index < 0) {
            System.out.println("Invalid Index value");
            return;
        }
        size++; 

        Node newNode = new Node(data);
        if(head == null || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for(int i=1; i<size; i++) {
            if(i == index) {
                Node nextNode = current.next;
                current.next = newNode;
                newNode.next = nextNode;
                break;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        O3_add_any_Given_position list = new O3_add_any_Given_position();

        list.addLast("abc");
        list.addLast("mno");
        list.addLast("pqr");
        list.addLast("xyz");
        list.addInMiddle(2, "AMPX"); 

        list.display();
    }
}


