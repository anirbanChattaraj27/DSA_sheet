public class O1_linear_serach {
    public static int search(int arr[], int item){
        int len = arr.length;
        for(int i=0; i<len; i++){
            if(arr[i] == item)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 56, 67, 55};
        int item = 55;

        int result = search(arr, item);
        if(result == -1){
            System.out.println("item is not present");
        }
        else{
            System.out.println(item + " is present, at the index of " + result);
        }
    }
}
 