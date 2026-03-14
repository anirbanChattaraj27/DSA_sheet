public class O1_queue_using_array{
 

    static int arr[];
    static int size;
    static int rear;

    O1_queue_using_array(int size) {
        this.size = size;
        arr = new int[size];
        rear = -1;
    }

    public static boolean isEmpty() {
        return rear == -1;
    }

    public static boolean isFull() {
        return rear == size-1;
    }

    public static void peek() {
        if(!isEmpty()) {
            System.out.println(arr[0]);  // 1st element is our top or peek
        } else{
            System.out.println("empty");
        }
    }

    // enqueue O(1)
    public static void add(int data) {
        if(!isFull()) {
            rear++;
            arr[rear] = data;
        } else {
            System.out.println("Overflow");
            return;
        }
    }

    // Dequeue O(n)
    public static int remove() {
        if(!isEmpty()) {
            int front = arr[0]; // this is queue data structure so delete 1st element
            for(int i=0; i<rear; i++) { // here loop is running for all elements
                arr[i] = arr[i+1];
            }
            rear--;	// elements are shifted to 1 place previous index so 
            return front;                
        }
        else{
            System.out.println("empty queue");
            return -1;
        }

        
    }


    public static void main(String args[]) {
        O1_queue_using_array q = new O1_queue_using_array(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.peek();
    }
}