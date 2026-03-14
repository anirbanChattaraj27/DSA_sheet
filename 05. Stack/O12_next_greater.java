
public class O12_next_greater {

    static void nextGreater(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
        }
    }

    static void nextGreater2(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    flag = true;
                    break;
                }
            }
            if (flag == false)
                System.out.print("- ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 30, 50, 20, 15, 25 };
        int size = arr.length;
        nextGreater(arr, size);
    }
}