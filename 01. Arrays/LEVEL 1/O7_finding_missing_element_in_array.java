public class O7_finding_missing_element_in_array {

    public static int findMissingNumbers(int[] arr) {
        
        // formula: sum of n natural num = n*(n+1)/2;
        // total - sum of array elements
        int n = arr.length + 1;
        int sum = 0;
        int total = n * (n + 1) / 2;
    
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return total-sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        System.out.println(findMissingNumbers(arr));
    }
}
