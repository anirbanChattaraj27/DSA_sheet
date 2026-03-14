public class O2_I_Max_consecutive_ONEs {

    public static int countConsecutiveOnes(int[] arr) {

        int maxConsecutiveOne = 0;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {

            // If one is found, then increment zeroCount
            if (arr[i] == 1) {
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
        int[] arr = { 1, 1, 0, 0, 1, 1, 1, 1, 1 };
        System.out.println(countConsecutiveOnes(arr));
    }
}

// Input: {1, 1, 0, 0, 1, 1, 1, 1, 1}
// Output: 5