public class O6_move_zeros_end_of_array {

    public static void display(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void printArray() {

        int[] arr = {12, 0, 0, 12, 12, 45, 78, 0, 65, 65, 00, 0};
        
        moveZeros(arr, arr.length);
        display(arr);
    }

    public void moveZeros(int[] arr, int n) {

        int j = 0;
        int i=0;
        
        while(i<arr.length){
            if(arr[i] == 0){
                i++;
            }
            else{
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                i++;
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        O6_move_zeros_end_of_array arrUtil = new O6_move_zeros_end_of_array();
        arrUtil.printArray();

    }

}
