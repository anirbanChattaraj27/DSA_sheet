import java.net.SocketPermission;
import java.security.Principal;
import java.util.Scanner;

import javax.swing.SpringLayout;

import org.w3c.dom.UserDataHandler;

public class I_printing_arrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A[] = new int[10];  // we've to use new for creating array, int means this is int type array i am writing and its a 10 size arrays i have created
        int B[] = {1,22,43,5,76,53};

        // // ************print A************
        A[2] = 45;
        A[3] = 58;
        A[5] = 95;
        A[9] = 4516;
        A[6] = 65; 
        A[1] = 54;
        A[0] = 78;
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + " " );
        }

        // // ****************print B***************
        System.out.println("\n\n printing b");
        System.out.println(B[0]);
        System.out.println(B[2]);
        System.out.println(B[4]);

        //  ******************** FOR EACH LOOP **********************\\
        for (int x: B)
        System.out.println(x);  // in for each loop just write x nd it;'ll print all the elements'


        // // ************print LENGTH*****************
        System.err.println("\n\n" + "the length of array B is : " + B.length);





        // using user input
        System.out.println("total no elements");
        int n = s.nextInt();
        int arr[] = new int[n];

        System.out.println("enter all elements");
        for(int i=0; i<arr.length; i++){   //i<n is also applicable
            arr[i] = s.nextInt();
        }

        System.out.println("elements are");
        for(int i=0; i<arr.length; i++){ // i<n is  also applicable
            System.out.println(arr[i]);
        }
    }
}
