import javax.sound.sampled.AudioFormat.Encoding;

public class O6_merge_sort {

    public static void divide(int arr[], int startIndx, int endIndx) {

        if (startIndx < endIndx) {
            
            int mid = startIndx + (endIndx - startIndx) / 2;
            divide(arr, startIndx, mid); // after dividing array 1st half array is start index to mid index
            divide(arr, mid + 1, endIndx); // and rest part of array is mid+1 index to end index

            concquer(arr, startIndx, mid, endIndx);
        }
    }

    public static void concquer(int arr[], int startIndx, int mid, int endIndx) {

        int merged[] = new int[endIndx - startIndx + 1];

        int index1 = startIndx; // index1 starts from starting index // this tracks 1st array
        int index2 = mid + 1; // index2 starts from ending index // this tracks 2nd array
        int x = 0; // this tracks merged array's index

        while (index1 <= mid && index2 <= endIndx) // upto when index1 <= mid and index2 <= endindex sort elements
        {
            if (arr[index1] <= arr[index2]) { // compare array of index1 smaller or equal with array of index2
                merged[x++] = arr[index1++]; // then put index1 elements in merged array and increment them
            } else {
                merged[x++] = arr[index2++]; // if index2 elements are greater then put them in merged array and increment them
            }
        }

        // rest elemets will copied here
        while (index1 <= mid) { // if elemnts left in index1 then
            merged[x++] = arr[index1++]; // then store them in merged array
        }

        while (index2 <= endIndx) { // if elemnts left in 2nd index then put them here
            merged[x++] = arr[index2++];
        }

        // here copiyng mereged arrays elements in original array
        int i=startIndx, j=0;
        while ((i < arr.length) && (j < merged.length)) {
            arr[i++] = merged[j++];
        }
    }

    public static void main(String[] args) {

        int arr[] = { 6, 3, 9, 2, 5, 8 };
        int n = arr.length;
        divide(arr, 0, n-1);

        // display
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
