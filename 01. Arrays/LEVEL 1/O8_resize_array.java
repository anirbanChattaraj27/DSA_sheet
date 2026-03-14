public class O8_resize_array {
    public static void display(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] resize(int[] arr, int capacity)
    {
        int[] temp = new int[capacity];
        for(int i=0; i<arr.length; i++)
        {
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    public static void main(String[] args)
    {
        O8_resize_array  arrayUtil = new O8_resize_array();

        int[] originalArr = new int[] {21, 45, 7, 45}; 

        System.out.println("The size of original array is: " + originalArr.length); 

        originalArr = arrayUtil.resize(originalArr, 10);

        System.out.println("The size of the resized original array: " + originalArr.length);
    }
}
