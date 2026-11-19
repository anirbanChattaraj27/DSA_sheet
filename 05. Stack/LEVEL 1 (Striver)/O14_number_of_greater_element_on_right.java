// Input: arr[] = {3, 7, 1, 5, 9, 2} 
// Output: {3, 1, 3, 1, 0, 0} 
 
/*  APPROCH:
    ~ I will take 2 stack 1 is MainStack and 1 is TempStack and a arrayList to store the count
    ~ Now, I will add elements to the main stack and if st.peek() > arr[i] then push it in TempStack, pop from MainStack
    ~ and print the size of tempStack
    ~ again push back all the elements to the TempStack
    ~ again check for next arr[i] and check the same condition wheather st.peek() > arr[i], if condition satifies pop from MainStack and push it in Tempstack and print the size of temoStack
*/

import java.util.*;
  
public class O14_number_of_greater_element_on_right {
    public static int[] countGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        // Keeps elements seen so far sorted in ascending order (largest at top)
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Move elements strictly greater than arr[i] to tempStack
            while (!mainStack.isEmpty() && mainStack.peek() > arr[i]) {
                tempStack.push(mainStack.pop());
            }

            // Number of elements moved equals count of greater elements to the right
            result[i] = tempStack.size();

            // Insert current element in sorted position
            mainStack.push(arr[i]);

            // Restore elements back to mainStack
            while (!tempStack.isEmpty()) {
                mainStack.push(tempStack.pop());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 5, 9, 2};
        System.out.println(Arrays.toString(countGreaterElements(arr)));
        // Output: [3, 1, 3, 1, 0, 0]
    }
}
