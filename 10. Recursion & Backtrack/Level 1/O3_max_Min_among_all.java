
//Largest / Smallest Element of the array using Recursion in Java
public class O3_max_Min_among_all {
    
    public static int findMin(int A[], int n){

        // if size = 0 means whole array has been traversed
        if(n == 1){
            return A[0];
        }
        return Math.min(A[n-1], findMin(A, n-1));
        // return Math.max(A[n-1], findMinMax(A, n-1));
    }

    public static int findMax(int A[], int i, int CurrMax){

        // int CurrMax = A[0];

        if( A.length == i ){
            return CurrMax;
        }

        if(A[i] > CurrMax){
            CurrMax = A[i];
        }

        return findMax(A, i+1, CurrMax);

    }

    public static void main(String args[]){

        int A[] = { 15, 60, -6, 0, 2};

        // Function calling
        System.out.println("largest element in the array is: " + findMax(A, 0, A[0]));
        System.out.println("smallest element in the array is: " + findMax(A, 0, A[0]));
    }
}
