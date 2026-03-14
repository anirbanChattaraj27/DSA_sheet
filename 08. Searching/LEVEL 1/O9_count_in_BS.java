// how many times an element appears in array and print its count, using B.S.
// arr = 12, 20, 45, 45, 45, 56, 78
// o/p --> 3  // 4 - 2 + 1 = 3

// count element how many times it occurs
// so formula is --> 1st occurence - last occurence + 1

public class O9_count_in_BS{

    public static int firstOccurence(int arr[], int element){
        int start = 0;
        int end = arr.length - 1;
        int result = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(element == arr[mid])
            {
                result = mid;  // here store mid value
                end = mid - 1;  // search in left side for the value if value found then in middle then go to left side and if left side also value found then store this value in result variable and if value will not found in left side then return mid value
            }

            else if(element < arr[mid]){
                end = mid - 1;
            }

            else{
                start = mid + 1;
            }
        }
        return result;
    }

    public static int lastOccurence(int arr[], int element){
        int start = 0;
        int end = arr.length - 1;
        int result = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(element == arr[mid])
            {
                result = mid;
                start = mid + 1;
            }

            else if(element < arr[mid]){
                end = mid - 1;
                // return end;
            }

            else{
                start = mid + 1;
                // return start;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array[] = {12, 20, 20, 45, 45, 45, 56, 78};
        int x = 45;

        int result = firstOccurence(array, x) - lastOccurence(array, x);
        result = result + 1;

        if(result == -1)
            System.out.println("not found");
        else
            System.out.println("value " + x + " found at " + result + " index");

    }
}