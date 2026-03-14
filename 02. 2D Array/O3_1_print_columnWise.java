
import java.util.Scanner;

public class  O3_1_print_columnWise {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total no of rows ");
        int n = sc.nextInt();
        System.out.println("Enter total no of columns ");
        int m = sc.nextInt();

        int [][] arr = new int[n][m];

        // taking input in array
        System.out.println("enter matrix elements");
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        // display wave array
        System.out.println("Displaying...");
        for(int j=0; j<arr[0].length; j++)
        {
            for(int i=0; i<arr.length; i++)
            {
                System.out.print(arr[i][j] + " ");
            }                    
        }
        

    }
}

// Enter total no of rows 
// 2
// Enter total no of columns 
// 2
// enter matrix elements
// 1 2
// 3 4
// Displaying...
// 1 3 2 4 