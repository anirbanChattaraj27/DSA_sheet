// Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
// Output:  countArray[]  =  {6, 1, 1, 1, 0, 1, 0} 

// Input:   arr[] =  {5, 4, 3, 2, 1}
// Output:  countArray[]  =  {4, 3, 2, 1, 0} 

// Input:   arr[] =  {1, 2, 3, 4, 5}
// Output:  countArray[]  =  {0, 0, 0, 0, 0}

/*
 * Given an unsorted array arr[] of distinct integers, construct another array countArray[] such that countArray[i] contains the count of smaller elements on the right side of each element arr[i] in the array.
*/

//  algorithm:-
//  create an dummy array
//  initialized them with 0
//  whenever i'll get smaller element increase count of each index 
//  rest index already 0 so if count will not increased then those are remain 0  

public class O37_count_smaller_elements_on_its_rigth {

    static void func11(int arr[]){

        System.out.println("without using array: ");
        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
            System.out.print (count +  " ");
        }
    }

    static void constructLowerArray(int arr[], int countArray[], int n) {

        System.out.println("using array: ");
        // initialize all the counts in countArray array as 0
        for (int i = 0; i < n; i++)
            countArray[i] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    countArray[i]++;
            }
        }

        for (int i = 0; i < countArray.length; i++) {
            System.out.print(countArray[i] + " ");
        }
        System.out.println();
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        int arr[] = { 12, 1, 2, 3, 0, 11, 4 };
        int n = arr.length;
        int low[] = new int[n];
        constructLowerArray(arr, low, n);

        func11(arr);
    }
}
