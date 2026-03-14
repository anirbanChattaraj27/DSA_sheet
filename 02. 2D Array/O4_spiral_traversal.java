import java.util.Scanner;

public class O4_spiral_traversal {
    
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
        
        System.out.println("Display:");
        int minRow = 0;
        int minColumn = 0;
        int maxRow = arr.length-1;
        int maxColumn = arr[0].length-1;
        int totalElements = m * n; // total no of elements 
        int count = 0;

        while(count < totalElements){

            // left Wall
            for(int i=minRow, j=minColumn; i<=maxRow && count < totalElements; i++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            minColumn++;

            // bottom wall
            for(int i=maxRow, j=minColumn; j<=maxColumn && count < totalElements; j++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxRow--;
            
            // right wall
            for(int i=maxRow, j=maxColumn; i>=minRow && count < totalElements; i--)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxColumn--;

            // up wall or top wall
            for(int i=minRow, j=maxColumn; j>=minColumn && count < totalElements; j--)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            minRow++;
        }
    }
}






// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 11 12 13 14
// 21 22 23 24
// 31 32 33 34
// 41 42 43 44
// 
// Display:
// 11
// 21
// 31
// 41
// 42
// 43
// 44
// 34
// 24
// 14
// 13
// 12
// 22
// 32
// 33
// 23