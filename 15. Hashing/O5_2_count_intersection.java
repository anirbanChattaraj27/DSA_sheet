// Time complexity : O(m*(m+n), Auxiliary space complexity O(1) 
// m = Size of array 1, n = size of array 2

public class O5_2_count_intersection {

    public static int intersectionOf2Arr(int[] arr1, int[] arr2, int size1, int size2) {
        int count = 0;

        //from here ✨✨✨✨
        for (int i = 0; i < size1; i++) {
            int flag = 0;

            for (int j = i + 1; j < size1; j++) {
                if (arr1[i] == arr1[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                continue;  // upto here ✨✨✨✨ code is same like distinct element

            for (int j = 0; j < size2; j++) { // here travarsing 2nd array and checking if arr1[i] == arr2[j] is same.... if same then add into arrayList and break.. bcz after finding same element dont want to travarse rest array
                if (arr1[i] == arr2[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // Time complexity : O(m*(m+n), Auxiliary space complexity O(1)
    // m = Size of array 1, n = size of array 2
    public static void main(String[] args) {
        int[] arr1 = { 5, 8, 5, 7, 8, 10 };
        int[] arr2 = { 1, 5, 5, 8, 1, 8, 7, 10};

        int size1 = arr1.length;
        int size2 = arr2.length;
        System.out.println(intersectionOf2Arr(arr1, arr2, size1, size2)); // o/p--> 4 bcz 5, 8, 7, 10 are common
    }
    
}