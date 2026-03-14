public class O2_circular_queue_using_array{

    static class Queue {
        static int arr[];
        static int size;
        static int front = -1;
        static int rear = -1;
  
        Queue(int size) {
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }
  
        public static boolean isFull() {
            return (rear+1)%size == front;
        }
  
        // enqueue O(1)
        public static void add(int data) {
            if(isFull()) {
                System.out.println("Overflow");
                return;
            }
            //if it's the 1st element
            if(front == -1) {
                front = 0;
            }
  
            rear = (rear + 1)%size;
            arr[rear] = data;
        }
  
        // dequeue O(1)
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int res = arr[front];

            // if 1 element is there Queue
            if(front == rear) { // if front = rear means 1 element is present
                front = rear = -1; // front and rear pointer points on -1 means out of queue
            } 
            // if more than 1 element is present in queue
            else {
                front = (front+1)%size;
            }
            return res;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
           
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);
  
        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    } 
}