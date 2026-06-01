// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class O1_remove_duplicate_from_sorted_array {
    public int removeDuplicates(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(j > 0 && arr[j-1] != arr[j]){
                i++;
                arr[i]=arr[j]; // array is passing by referene in this code so modify the array as well
            }
        }
        return i+1;
        
    }
}
