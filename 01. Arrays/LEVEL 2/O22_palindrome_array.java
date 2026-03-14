// NOTE: compare 2 arraylist elements using .equals()
//       reverse arraylist

import java.util.*;

import javax.swing.plaf.metal.MetalBorders.PaletteBorder;
import javax.swing.text.PlainDocument;

public class O22_palindrome_array {

    public static boolean palindrome(int arr[]){

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            list1.add(arr[i]);
        }
        for(int i=0; i<arr.length; i++){
            list2.add(arr[i]);
        }

        Collections.reverse(list1);

        return list1.equals(list2);  
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 2, 1};
        System.out.println(palindrome(arr));        
    }
}
