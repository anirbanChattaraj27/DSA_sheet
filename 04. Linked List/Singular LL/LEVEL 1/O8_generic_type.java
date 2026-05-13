import java.util.*;

public class O8_generic_type {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // // add in LL
        list.addFirst(6);
        list.addFirst(5);
        list.add(5);  // this will add last
        list.add(2, 4);  // this will add 4 in 2nd index
        System.out.println(list);

        list.addLast(55);
        System.out.println(list);

        System.out.println(list.size());  // return size 


        // // print using loop
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i) + " -> ");  // take input from user
        }
        System.out.println(); 

        Collections.sort(list);


        /*searching for data in loop*/

        // for(int i = 0; i<list.size(); i++){
        //     if(list.get(i) == value)
        //         System.out.println(value);  // take input from user
        // }

        // // delete in LL
        // list.removeFirst();
        // list.removeLast();
        // System.out.println(list);

        // // delete with index no
        list.remove(2);  // remove 2nd index
        System.out.println(list);

        // reverse LL
        // Collections.reverse(list);
    }
}