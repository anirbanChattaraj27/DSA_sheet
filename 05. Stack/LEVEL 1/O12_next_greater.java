

import java.util.*;

public class O12_next_greater {

    static void nextGreater(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
                else{
                    System.out.print("-");
                }
            }
        }
    }

    static void nextGreater2(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    flag = true;
                    break;
                }
            }
            if (flag == false)
                System.out.print("- ");
        }
    }

    static ArrayList<String> nextGreaterOPTIMIZED(int[] arr, int size) {
        ArrayList<String> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        // concept is, I am putting vslues in stack from last to first
        s.add(arr[size - 1]);
        list.add("-");

        for (int i = size - 2; i >= 0; i--) // loop starts from end of array and move left side
        {
            while (!s.isEmpty() && s.peek() <= arr[i])
                s.pop();

            String result = s.isEmpty() ? "-" : Integer.toString(s.peek());

            list.add(result);
            s.add(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = { 60, 70, 20, 15, 25 };
        int size = arr.length;
        nextGreater2(arr, size);
    }
}


// when I am searching from last to first, when ever I will encounter an element which is smaller I will keep moving
// but if i find an element which is greater than I will remove the elment whic is smaler than this element from stack

/*

                    6
                    |
                4   |
        3       |   |
        |   2   |   |
    1   |   |   |   |
    |   |   |   |   |
    
    so when i am coming from last i.e.: 6 i will keep going upto 2 then I got 3, now from 3, I can go to 4, bcz 4 is the next gerater of 3
    so i will remove 2, now when I will reach 1, from 1 my next greater will be 3, I dont even require 2 again


*/