// an array has given and i have to find an elemnt which appears 1st... means,
// arr = 12, 20, 45, 45, 45, 56, 78
// o/p --> 4 index
// explanation--> 45 occurs 3 times so when we apply BS then mid 45 comes last bt that will be our 4th occurence means 4th index so i need to find last occurence so search in right side 

// store mid value in result variable then search in right side of array


public class O7_last_occurence_element{
    
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
        int array[] = {12, 20, 45, 45, 45, 56, 78};
        int x = 45;

        int result = lastOccurence(array, x);

        if(result == -1)
            System.out.println("not found");
        else
            System.out.println("value " + x + " found at " + result + " index");
    }
}