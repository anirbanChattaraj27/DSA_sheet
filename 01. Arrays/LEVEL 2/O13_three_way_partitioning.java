// Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}  , lowVal = 14 , highVal = 20
// Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}

// Explanation: all elements which are less than 14 are 
// present in the range of 0 to 6 all elements which are 
// greater than 14 and less than 20 are present in the range 
// of 7 to 8 all elements which are greater than 20 are present 
// in the range of 9 to 12       

// this qs is same as sort 0,1,2

public class O13_three_way_partitioning {

    public static void threeWayPartition(int[] arr, int lowVal, int highVal) {

        int n = arr.length;
        int start = 0, end = n - 1;

        for (int i = 0; i <= end;) {
            if (arr[i] < lowVal) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;

            }

            else if (arr[i] > highVal) {
                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
            }

            else
                i++;
        }
    }

    public static void main(String[] args) {

        int arr[] = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };

        threeWayPartition(arr, 10, 20);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
