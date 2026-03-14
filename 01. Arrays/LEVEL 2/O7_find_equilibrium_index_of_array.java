// i/p = 12, 16, 22, 12, 16
// o/p = 2
// bcz, 12+16+22 = 50 and 22 is in middle so this  is equilibrium index

public class O7_find_equilibrium_index_of_array {
    // Java program to find the equilibrium index of an array

    static int equilibrium_index(int arr[], int n) {

        int i, j;
        int leftsum, rightsum;
        
        for (i = 0; i < n; ++i) {

            leftsum = 0;
            for (j = 0; j < i; j++)
                leftsum += arr[j];

            rightsum = 0;
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];

            if (leftsum == rightsum)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int arr[] = { 1,2,1,1,2};
        int arr_size = arr.length;
        
        System.out.print("Equilibrium Index : ");
        System.out.println(equilibrium_index(arr, arr_size));
    }
}