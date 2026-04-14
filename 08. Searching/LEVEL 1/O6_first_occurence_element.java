// an array has given and i have to find an elemnt which appears 1st... means,
// arr = 12, 20, 45, 45, 45, 56, 78
// o/p --> 2 index
// explanation--> 45 occurs 3 times so when we apply BS then mid 45 comes 1st bt that will be our 2nd occurence so i need to find 1st occurence so search in left side 


// // store mid value in result variable then search in left side of array

public class O6_first_occurence_element{
    
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
        int array[] = {12, 20, 45, 45, 45, 45, 45, 45, 56, 78};
        int x = 45;

        int result = firstOccurence(array, x);

        if(result == -1)
            System.out.println("not found");
        else
            System.out.println("value " + x + " found at " + result + " index");

    }
}