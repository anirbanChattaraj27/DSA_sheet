import java.util.Stack;
public class O5_queue_using_2_stacks {

    public QueueUsingStacks() {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();
    }

    public void enqueue(int item) {
        input.push(item);
    }

    public int dequeue() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
}


