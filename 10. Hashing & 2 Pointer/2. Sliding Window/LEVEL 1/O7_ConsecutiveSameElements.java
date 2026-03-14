public class O7_ConsecutiveSameElements {

    public static int consecutiveSameElements(int[] arr) {

        int maxConsecutiveOne = 0;
        int count = 0;
        
        for (int i = 0; i < arr.length-1; i++) {
            
            for(int j=i+1; j<arr.length; j++) {

                // If zero is found, then increment zeroCount
                if (arr[i] == arr[j]) {
                    count++;
                    maxConsecutiveOne = Math.max(count, maxConsecutiveOne);
                } 
                else {
                    count = 0;
                }
            }

        }
        return maxConsecutiveOne;
    }

    public static void main(String[] args) {
        int[] arr = { 3,3,0,3,4,4,4,3 };
        System.out.println(consecutiveSameElements(arr));
    }
}

// Input: {2,3,0,0,3,3,3}
// Output: 3
// explain -> consecutive 3 numbers
// application of consecutive ones

// weird array qs at ACCOLITE