import java.util.Scanner;

import javax.naming.NamingException;

// difference betwwn maximum no of an array and minimum no of that array
// arr = [3, 5, 54, 34, 65, 90, 89, 67]
// o/p: 90 - 3 = 87

public class O9_difference_btwn_max_min_in_array {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        // arrays length
        System.out.println("Enter total no of elements in array: ");
        int n = s.nextInt();
        int[] arr = new int[n];

        // taking input from user
        for(int i=0; i<arr.length; i++)
        {
            System.out.println("Enter element");
            arr[i] = s.nextInt();
        }

        // checking max and min
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > max)
                max = arr[i];

            if(arr[i] < min)
                min = arr[i];
        }

        // difference between  max and min
        int span = max - min;
        System.out.println("span is: " + span);
    }
}
