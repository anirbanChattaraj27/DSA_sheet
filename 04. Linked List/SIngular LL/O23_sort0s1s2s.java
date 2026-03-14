// code is correct bt some minor mistakes are in code
// https://www.youtube.com/watch?v=tip_I-RCXIk


// time --> O(n) space --> O(1)
public class O23_sort0s1s2s {

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
    public Node sort0s1s2s() {
        int[] countArr = {0, 0, 0};
        Node temp = head;

        while(temp != null){
            countArr[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int i=0;

        while(temp != null){
            if(countArr[i] == 0){
                i++;
            }
            else{
                temp.data = i;
                countArr[i]--;
                temp = temp.next;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        O23_sort0s1s2s list = new O23_sort0s1s2s();

        list.addLast(0);
        list.addLast(2);
        list.addLast(1);
        list.addLast(2);
        list.addLast(0);
        list.display();

        // 1st way to print
        // Node midNode = list.sort0s1s2s();
        // System.out.println("middle node is: " + midNode.data);

        // 2nd way to print
        System.out.println(list.sort0s1s2s().data);
    }
}


