import java.util.*;


//  push at bottom of the stack
// popped out all the elements then stack will be called as empty stack then push the element... this will be your top then push all the element. 


public class O5_push_At_Bottom {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();  // popped out elements, stored in top variable
        pushAtBottom(s, data); // popped out all data then push new element
        s.push(top); // push all elements
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtBottom(stack, 4);

        while(!stack.isEmpty()) { // displaying stack daata
            System.out.println(stack.pop());
        }
    }
}
