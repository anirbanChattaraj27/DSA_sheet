
public class O12_next_greater {

    static void nextGreater(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
                else{
                    System.out.print("-");
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
        int[] arr = { 60, 70, 20, 15, 25 };
        int size = arr.length;
        nextGreater2(arr, size);
    }
}