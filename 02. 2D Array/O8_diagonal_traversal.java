import java.util.Scanner;


public class O8_diagonal_traversal {
    
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
        
        // dispaly code
        System.out.println("Display:");

        for(int gap = 0; gap < arr.length; gap++){
            for(int i=0, j=gap; j<arr.length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    
    }
}



// Enter total no of rows 
// 2
// Enter total no of columns 
// 2
// enter matrix elements
// 11 12
// 21 22

// display
// 11
// 22
// 12



// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
// Display:
// 1
// 6
// 11
// 16
// 2
// 7
// 12
// 3
// 8
// 4