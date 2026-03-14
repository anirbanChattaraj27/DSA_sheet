public class O4_find_Min{

    public static void display(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int findMin(int[] arr)
    {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("invalid input");
        }

        // initialize min with 1st element of the array
        int min = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    // main function
    public static void main(String[] args)
    {
        int arr[] = {5, 5, 6, 8, 1, 5};
        O4_find_Min fM = new O4_find_Min();
        System.out.println(fM.findMin(arr));
    }
    
}

