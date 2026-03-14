import java.util.*;

public class O1_insert_in_first {

    
    // creating node
    public class Node {
        String data;
        Node next;
        
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    
    // diaply LL 
    public void display(){
        if (head == null){
            System.out.println("Empty list");
            return;
        }

        Node lastNode = head;
        while (lastNode != null) {
            System.out.print(lastNode.data + "->");
            lastNode = lastNode.next;
        }
        System.out.print("NULL");
    }

    // insert at first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        // if head is not null then,
        newNode.next = head; // newNode points to head
        head = newNode;  // head's value is now newNode // means heads points to new node
    }

    public static void main(String[] args) {
        O1_insert_in_first list1 = new O1_insert_in_first();
        O1_insert_in_first list2 = new O1_insert_in_first();

        list1.addFirst("abc");
        list1.addFirst("xyz");
        list1.display();
        
        Scanner sc = new Scanner (System.in);
        
        for(int i=0; i<3; i++){
            list2.addFirst(sc.next());
        }
        list2.display();

    }
}
