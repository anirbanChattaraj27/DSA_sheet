import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class O0_PQ {
    public static void pq(int arr[]){

        // this print list in sorted order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x: arr){
            pq.add(x); // adding elements to PQ
        }

        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");  // this will diaplay peek element by default peek element will be smaller element
            pq.remove(); // this will remove peek element after printing
        }
    }

    public static void pq_Reverse(int arr[]){

        // this will display elements sorted and reverse order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x: arr){
            pq.add(x); // adding elements to PQ
        }

        while(pq.size() > 0){
            System.out.print(pq.peek() + " ");  // this will diaplay peek element by default peek element will be smaller element
            pq.remove(); // this will remove peek element after printing
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 6, 2};
        pq(arr);
        System.out.println();
        pq_Reverse(arr);
    }
}
