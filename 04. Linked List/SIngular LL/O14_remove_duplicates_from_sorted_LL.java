
import java.util.*;
public class O14_remove_duplicates_from_sorted_LL {

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

    public int removeDuplicate() {  // i can also do public Node removeDuplicate
        if(head == null){
            return 0;
        }

        Node current = head; // creating 1 pointer which starat from head
        while(current != null && current.next != null){
            if(current.data == current.next.data) // current's data and current's next data will be same then 
                current.next = current.next.next;  // point current node to the next node of current means next element of current will be remeove bcz no connect is there
            else  // if nodes are not same then
                current = current.next;  // current moves to current
        }
        return 0;
    }

    public static void main(String[] args) {
        O14_remove_duplicates_from_sorted_LL list = new O14_remove_duplicates_from_sorted_LL();

        list.addLast(5);
        list.addLast(8);
        list.addLast(8);
        list.addLast(8);
        list.addLast(25);
        list.addLast(29);
        list.addLast(29);
        list.addLast(29);
        list.addLast(29);

        list.display();

        list.removeDuplicate();
        list.display();
    }
}

