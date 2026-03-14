
//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

import java.util.HashSet;

import javax.print.attribute.HashAttributeSet;

public class O16_common_element_from_3_sorted_Array {

	
	static void func(int arr1[], int arr2[], int arr3[]){
		HashSet<Integer> set1 =new HashSet<>();
		HashSet<Integer> set2 =new HashSet<>();
		HashSet<Integer> set3 =new HashSet<>();

		for(int i=0; i<arr1.length; i++){
			if(!set1.contains(arr1[i])){
				set1.add(arr1[i]);
			}
		}
		for(int i=0; i<arr2.length; i++){
			if(!set2.contains(arr2[i])){
				set2.add(arr2[i]);
			}
		}
		for(int i=0; i<arr3.length; i++){
			if(!set3.contains(arr3[i])){
				set3.add(arr3[i]);
			}
		}

		for(int x: set3){
			if(set1.contains(x) && set2.contains(x)){
				System.out.print (x + " ");
			}
		}
	}

	// TODO Auto-generated method stub
	public static void findCommon(int ar1[], int ar2[], int ar3[]) {
		// Initialize starting indexes for ar1[], ar2[] and
		// ar3[]
		int i = 0, j = 0, k = 0;

		// Iterate through three arrays while all arrays have elements
		while (i < ar1.length && j < ar2.length && k < ar3.length) {

			// If array1 =array2 and array2 = array3 then print any one of them and increment i, j, k
			if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
				System.out.print(ar1[i] + " ");
				i++;
				j++;
				k++;
			}

			// x < y
			else if (ar1[i] < ar2[j])
				i++;

			// y < z
			else if (ar2[j] < ar3[k])
				j++;

			// We reach here when x > y and z < y, i.e., z is smallest
			else
				k++;
		}
	}


	// Driver code to test above
	public static void main(String args[]) {
		int ar1[] = { 1, 5, 10, 20, 40, 80 };
		int ar2[] = { 6, 7, 20, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.print("Common elements are ");
		findCommon(ar1, ar2, ar3);
		System.out.print("\nCommon elements are ");
		func(ar1, ar2, ar3);
	}
}
