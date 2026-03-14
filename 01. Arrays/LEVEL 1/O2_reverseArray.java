public class O2_reverseArray {
    
    public static void display(int[] arr)
    {
        // int n = arr.length;
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }    

    public static void reverse(int[] nums){
        int start = 0, end = nums.length-1;

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] reverse2(int[] arr){
        int newArr[] = new int[arr.length];
        int idx=0;
        for(int i=arr.length-1; i>=0; i--){
            newArr[idx++] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args)
    {
        int[] num = {72, 11, 45, 00, 65, 19};

        // // for 1st function
        // reverse(num);
        // display(num);
        
        // // for 2nd function
        int[] reversedArr = reverse2(num);
        reverse2(num);
        display(reversedArr);
    }
}
