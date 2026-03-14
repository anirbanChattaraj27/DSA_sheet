import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class O10_searching_element_in_array {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        // total no of elemets
        System.out.println("Enter total no of elements: ");
        int n = s.nextInt();
        int[] arr = new int[n];

        // enter elemts in array
        System.out.println("Enter elemets in array");
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }

        System.out.println("Enter which element u want to search");
        int data = s.nextInt();

        // initilized index with -1
        int index = -1;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == data){
                index = i;
                break; // i think use of break statement
            }
        }
        System.out.println("element is present at " + index + " index");
    }
}
