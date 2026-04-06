import java.util.*;


public class O6_reverse_stack
{
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();  // popped out elements, stored in top variable
        pushAtBottom(s, data); // popped out all data then push new element
        s.push(top); // push all elements
    }

    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s); // call reverse function and pop elements 
        pushAtBottom(s, top);  // here we puch elements from bottom to top means first push 3, then 2, then 1
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);

        while(!stack.isEmpty()) { // displaying stack daata
            System.out.println(stack.pop());
        }
    }
}