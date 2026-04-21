public class O2_III_Max_Consecutive_same_element {
    
public static int countConsecutiveOnes(int[] arr) {

        int maxConsecutiveOne = 0;
        int count = 1; // initialize to 1, make
        
        for (int i = 0; i < arr.length-1; i++) {

            // If 2 indices have same element, then increment Count
            if (arr[i] == arr[i+1]) {
                count++;
                maxConsecutiveOne = Math.max(count, maxConsecutiveOne);
            }
            else {
                count = 0;
            }
        }
        return maxConsecutiveOne;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 2, 2, 2, 3, 3 };
        System.out.println(countConsecutiveOnes(arr));
    }
}