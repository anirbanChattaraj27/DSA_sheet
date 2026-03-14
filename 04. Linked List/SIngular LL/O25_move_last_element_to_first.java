public class O25_move_last_element_to_first {
    
    Node head;

    // creating node
    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
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

    // move last idx to first
    public void moveLastToFirst() {
        Node first = head.next;
        Node second = head;
  
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second = null;
        first = head;

        // return first;
    }

    public static void main(String[] args) {
        O25_move_last_element_to_first list = new O25_move_last_element_to_first();

        list.addFirst("abc");
        list.addFirst("mnp");
        list.addFirst("pqr");
        list.addFirst("xyz");


        System.out.println(list.moveLastToFirst());
        // list.display();
    }

    
}

