// LC 11
/*
Input: arr[] = [1, 5, 4, 3]
Output: 6
Explanation: 5 and 3 are 2 distance apart. So the size of the base = 2. 
Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6.

Input: arr[] = [3, 1, 2, 4, 5]
Output: 12
Explanation: 5 and 3 are 4 distance apart. So the size of the base = 4. 
Height of container = min(5, 3) = 3. So total area = 4 * 3 = 12.

 */
public class O12_Containers_with_most_water {

    // BRUTE force
    static int maxWater(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
              
                // calculate the amount of water
                int amount = 
                    Math.min(arr[i], arr[j]) * (j - i);
              
                // keep track of maximum amount of water
                res = Math.max(amount, res);
            }
        }
        return res;
    }

    // OPTIMIZED 2 pointer
    static int maxWater2(int[] arr) {

        int left = 0, right = arr.length - 1;
        int res = 0;
        while (left < right) {

            // find the water stored in the container between 
            // arr[left] and arr[right]
            int water = Math.min(arr[left], arr[right]) * (right - left);
            res = Math.max(res, water);

            if (arr[left] < arr[right]) {
                left += 1;
            } 
            else {
                right -= 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWater(arr));
    }
}
