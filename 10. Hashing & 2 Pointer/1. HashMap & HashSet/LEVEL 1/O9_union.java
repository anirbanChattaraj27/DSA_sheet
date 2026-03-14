
// The union of two arrays will contain all the elements of the two arrays, the common elements will appear only once instead of twice. The intersection of the two arrays will contain the common elements of the two arrays.


// Java program for the union of two arrays using Set
import java.util.*;

class O9_union {
    static void getUnion1(int a[], int n, int b[], int m) {

        // Defining set container s
        HashSet<Integer> s = new HashSet<>();

        // Inserting array elements in s
        for (int i = 0; i < n; i++)
            s.add(a[i]);

        for (int i = 0; i < m; i++)
            s.add(b[i]);

        System.out.print("Number of elements after union operation: " + s.size() + "\n");
        System.out.print("The union set of both arrays is :" + "\n");

        System.out.print(s +  " "); // s will contain only distinct
        // elements from array a and b
        System.out.println();
    }

    public static void union2(int arr1[],int n, int arr2[], int m){
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            if(!set.contains(arr1[i])){
                set.add(arr1[i]);
            }
        }
        for(int i=0; i<m; i++){
            if(!set.contains(arr2[i])){
                set.add(arr2[i]);
            }
        }
        System.out.println(set);
    }

    public static void union3(int arr1[],int n, int arr2[], int m){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(arr1[i]);
            
        for(int x : arr2){
            if(!set.contains(x)){
                set.add(x);
            }
        }
        // System.out.println(set);
        for(int x:set){
            System.out.print (x + " ");
        }
    }
    
    // Driver Code
    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 6, 2, 3, 5, 7, 3 };
        int b[] = { 2, 4, 5, 6, 8, 9, 4, 6, 5, 4 };

        getUnion1(a, 9, b, 10);
        union2(a, 9, b, 10);
        union3(a, 9, b, 10);
    }
}
