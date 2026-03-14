import java.security.Principal;
import java.util.Scanner;

public class O3_wave_traversal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total no of rows ");
        int n = sc.nextInt();
        System.out.println("Enter total no of columns ");
        int m = sc.nextInt();

        int [][] arr = new int[n][m];

        // taking input in array
        System.out.println("enter matrix elements");
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // display wave array
        System.out.println("DISPLAY");
        for(int j=0; j<arr[0].length; j++) {
            if(j % 2 == 0) {
                for(int i=0; i<arr.length; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            }

            else { 
                for(int i=arr.length-1; i>=0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}


// Enter total no of rows 
// 3
// Enter total no of columns 
// 3
// enter matrix elements
// 11 12 13
// 21 22 23
// 31 32 33
// DISPLAY
// 11 21 31 32 22 12 13 23 33

