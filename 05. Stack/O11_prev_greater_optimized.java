
// previous greater element optimized
import java.util.*;

public class O11_prev_greater_optimized {

    static void prevGreater(int[] arr, int size) {

        Stack<Integer> s = new Stack<>();

        s.add(arr[0]);
        System.out.print("- ");

        for (int i = 1; i < size; i++) {
            while (s.isEmpty() == false && s.peek() <= arr[i]) {
                s.pop();
            }
            if (s.empty())
                System.out.print("- ");
            else
                System.out.print(s.peek() + " ");

            s.push(arr[i]);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 30, 50, 20, 15, 25 };
        int size = arr.length;
        prevGreater(arr, size);

    }

}