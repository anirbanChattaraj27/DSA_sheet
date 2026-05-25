public class O2_subArrays {
    public static void main(String[] args) {

        // The array elements
        int arr[] = { 1, 2, 3, 4 };
        System.out.println("The subarrays are- ");

        for (int i = 0; i < arr.length; i++){

            for (int j = i; j < arr.length; j++) {

                for (int k = i; k <= j; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
            }
        }
    }
}
