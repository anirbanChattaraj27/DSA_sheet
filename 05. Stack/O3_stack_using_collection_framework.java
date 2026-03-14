import java.util.*;



public class O3_stack_using_collection_framework{

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
    
        System.out.println("top -> " + s.peek());
        System.out.println("size -> " + s.size());
        System.out.println("popped -> " + s.pop());
        System.out.println("top -> " + s.peek());
        System.out.println("size -> " + s.size());
        
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
