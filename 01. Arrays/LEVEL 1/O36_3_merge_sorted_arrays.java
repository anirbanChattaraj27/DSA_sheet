// merge 2 sorted arrays into a sorted array

public class O36_3_merge_sorted_arrays {

    public static void Display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] mergeArr(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            // if ((arr1[i] == 0) || (arr2[j] == 0)) {
            //     continue;
            // }

            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // remaning elements in arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        // remaning elements in arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = { 12, 0, 32, 45};
        int arr2[] = { 13, 45, 46, 72, 74 };
        int arr3[] = new int[arr1.length + arr2.length];
        arr3 = mergeArr(arr1, arr2);

        Display(arr3);
    }
}
