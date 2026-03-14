import java.util.*;
 
public class O4_using_collection_framwork {

   public static void main(String args[]) {

        // ll queue
       //Queue<Integer> q = new LinkedList();

       // array queue
       Queue<Integer> q = new ArrayDeque();  // ArrayDeque means circular queue
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
 
       while(!q.isEmpty()) {
           System.out.println(q.peek());
           q.remove();
       }
   }
}