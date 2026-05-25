// hashset only allow unique elements =, cant add duplicates    
import java.util.*;
import java.util.Scanner;


public class O1_hashSet{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet < String > myHashset = new HashSet < String > ();

        myHashset.add("PrepInsta");
        myHashset.add("Learn");
        myHashset.add("Prime Video");

        /* enter elements in hash set using loop */
        System.out.println("Enter string: ");
        for(int i=0; i<3; i++){
            myHashset.add(sc.nextLine());
        }

        System.out.println(myHashset);
        System.out.println(myHashset.contains("learn"));

        /* loop in between set and print set elements */
        for (String s: myHashset) {
            System.out.print(s + " ");
        }

        System.out.println("");

        System.out.println(myHashset.size());
        boolean b = myHashset.contains("Learn");
        System.out.println(b);

        myHashset.remove("Learn");
        System.out.println(myHashset.size());

        System.out.print("****************************\n");
        Iterator < String > it = myHashset.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\n" + myHashset.isEmpty());
        myHashset.clear();
    }
}
