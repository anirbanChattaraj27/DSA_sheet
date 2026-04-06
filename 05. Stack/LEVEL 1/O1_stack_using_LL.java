public class O1_stack_using_LL{
    
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static class Stack{
        
        // there should be a head in LL and it'll be top of stack
        public static Node head = null;

        // stack empty function // return true if head is null, else return false
        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int data){
            // creating a new node to push the data  
            Node newNode = new Node(data);
            if(isEmpty()){ // if head is null 
                head = newNode; // if stack is empty, in that case new node will be our head
                return;
            }

            // if already elemnts are there in stack then newNode's next element would be head and then head points to newNode so newNode will be our new Head
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }

            Node top = head;  // as first head is first element so it is top
            head = head.next;  // make head's next as head
            return top.data;  // pop  out top means 1st element popped out
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            Node top = head;
            return top.data; 
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){  // until stack is not empty, print all the elements
            System.out.println(s.peek());
            s.pop();
        }   
    }
}