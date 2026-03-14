import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;



public class O13_next_greater_optimized{


    static ArrayList<String> nextGreater(int[] arr, int size)
    {
        ArrayList<String> list = new ArrayList<>();
        Stack <Integer> s = new Stack<>();

        s.add(arr[size - 1]);
        list.add("-");

        for (int i = size - 2; i >= 0; i--) // loop starts from end of array and move left side
        {
            while (!s.isEmpty() && s.peek() <= arr[i])
                s.pop();

            String result = s.isEmpty() ? "-" : Integer.toString(s.peek());

            list.add(result);
            s.add(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }


    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {30, 50, 20, 15, 25};
        int size = arr.length;
        for (String x : nextGreater(arr, arr.length))
        {
            System.out.print(x + " ");
        }
    }
}
