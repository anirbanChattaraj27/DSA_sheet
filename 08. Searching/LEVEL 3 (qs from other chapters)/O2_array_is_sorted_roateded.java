public class O2_array_is_sorted_roateded {
    public boolean check(int[] arr) {
        int count = 0;
        int n = arr.length;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > arr[(i+1) %n]){
                count++;
            }
        }
        return count <=1; 
    }
}
