// https://www.geeksforgeeks.org/java/stream-in-java/

import java.util.*;
import java.util.stream.Stream;

public class O1_basic{

    public static void main(String args[]){
        
        List<Integer> list = Arrays.asList(4,5,6);

        Stream<Integer> data = list.stream(); // converting list to stream

        long count = data.count(); 
        // System.out.println("Count: " + count);

        /* Once u use the stream, u cant reuse it, it will give exception */

        // if u want to reuse it, u can create a new stream from the list again
        // Stream<Integer> data2 = list.stream(); 
        // data2.forEach(n -> System.out.println(n)); // printing data inside stream


        list.stream()
            .filter(n -> n%2 == 1) // `filtering data inside stream, i am adding a filter, when this condtion will satisfy then only bellow steps will execute
            .sorted() // sorting data inside stream
            .map(n -> n*2) // mapping data inside stream
            .forEach(n -> System.out.println(n)); // printing data inside stream

    }
}