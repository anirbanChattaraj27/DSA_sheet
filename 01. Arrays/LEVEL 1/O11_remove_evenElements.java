// NOTE: if i want to return an array[] and parameter also contains an array


public class O11_remove_evenElements {

    public static void display(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    
        System.out.println();
    }

    public static int[] removeEven(int[] arr){

        int oddCount = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] % 2 != 0)
            {
                oddCount++;
            }
        }

        int[] result = new int[oddCount];
        int j = 0;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] % 2 != 0) {
                result[j++] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = {24, 2, 9, 12, 45};  // o/p->  9 45
        display(arr);

        
        int[] result = removeEven(arr);
        display(result);
    }
}
