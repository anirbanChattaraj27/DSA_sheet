
public class O16_remove_given_key_from_LL{

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

    // remove given key
    public void deleteNode(int key) {  // suppose key is 11
        Node current = head;  // current starts from head
        Node temp = null;  // temp starts from null

        if(current != null && current.data == key){ 
            head = current.next;
            return;
        }

        while(current != null && current.data != key){   // current should not equals to null and current data should not eqals to 11 // current data means at first 1 then after completing 1 loop it current data will be 8 after compl
            temp = current;  // move temp to current's place
            current = current.next;  // move current to next node
        }

        if(current == null){
            return;
        }

        temp.next = current.next;  // if key has found then temp's next points to currents next and current node will remove
    }

    public static void main(String[] args) {
        O16_remove_given_key_from_LL list = new O16_remove_given_key_from_LL();

        list.addLast(5);
        list.addLast(8);
        list.addLast(10);
        list.addLast(11);
        list.addLast(18);
        list.display();

        list.deleteNode(11);
        list.display();
    }
}


