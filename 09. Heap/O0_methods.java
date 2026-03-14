// String methods -> https://www.geeksforgeeks.org/priority-queue-class-in-java/

// other methods -> https://www.geeksforgeeks.org/priority-queue-class-in-java/



import java.util.*;

public class O0_methods {

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void addPeekPoll() {

        // Adding Elements: In order to add an element in a priority queue,
        // we can use the add() method. The insertion order is not
        // retained in the PriorityQueue. The elements are stored based
        // on the priority order which is ascending by default.

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println("using peek method -> " + pQueue.peek());

        // poll method will print top element and remove it
        System.out.println("after poll method -> " + pQueue.poll());

        // peek method will only print top element
        System.out.println("after peek and poll method ->  " + pQueue.peek());
    }

    /* ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨ */

    public static void offerMethod() {
        // The java.util.PriorityQueue.offer() method is used to insert
        // a particular element into the Priority Queue. It acts similar
        // to the add() method of Priority Queue.

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);

        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);

        // Inserting using offer()
        queue.offer(100);
        queue.offer(120);
        queue.offer(150);

        // Displaying th final Queue
        System.out.println("Priority queue after Insertion: " + queue);
    }

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void removePollMethod() {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        System.out.println("Initial PriorityQueue " + pq);

        // using the method
        pq.remove("Geeks");

        System.out.println("After Remove - " + pq);

        System.out.println("Poll Method - " + pq.poll());

        System.out.println("Final PriorityQueue - " + pq);
    }

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void travarsingInPriorityQueue() {

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");
        pq.add("For");
        pq.add("Geeks");

        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void travarsingInPriorityQueue2() {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(7);
        pq.add(8);
        pq.add(7);
        pq.add(4);
        pq.add(5);
        System.out.println("Elements of the Priority Queue: ");

        // iterate the Priority Queue
        for (int element : pq) {
            System.out.print(element + " ");
        }
    }

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void sizeMethod() {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);
        queue.add(18);

        // Displaying the PriorityQueue
        System.out.println("PriorityQueue: " + queue);

        // Displaying the size of the PriorityQueue
        System.out.println("The size of the queue is: " + queue.size());
    }

    // ✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨

    public static void toArrayMethod() {

        // Creating an empty PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);
        queue.add(25);

        // Displaying the PriorityQueue
        System.out.println("The PriorityQueue: " + queue);

        // Creating the array and using toArray()
        Object[] arr = queue.toArray();

        System.out.println("The array is:");
        for (int j = 0; j < arr.length; j++)
            System.out.println(arr[j]);
    }

    public static void main(String args[]) {
        addPeekPoll();

        travarsingInPriorityQueue2();

    }
}
