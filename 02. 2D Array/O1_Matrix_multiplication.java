/*
 * Two matrix will only able to multiply when no of elements of 1st matrix column and 2nd matrix row are same 
 * 1st matrix = 2 X 2✨   AND   2nd matrix = 2✨ X 3   // 1st 2 is column of 1sst matrix and 2nd 2 is row of 2nd matrix they are same so matrix is applicable for multiplication
 */



import java.util.Scanner;

public class O1_Matrix_multiplication {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1st matrix
        // total no of rows and columns
        System.out.println("enter no of rows ");
        int r1 = sc.nextInt();
        System.out.println("enter no of columns ");
        int c1 = sc.nextInt();

        // declare 1st matrix
        int[][] one = new int [r1][c1];

        // travarse 1st matrix
        System.out.println("enter elements for 1st matrix");
        for(int i=0; i<one.length; i++) // fill row
        {  
            for(int j=0; j<one[0].length; j++) // fill column
            { 
                one[i][j] = sc.nextInt(); // input of 1st matrix
            }
        }

        // 2nd matrix
        // total no of rows and columns
        System.out.println("enter no of rows ");
        int r2 = sc.nextInt();
        System.out.println("enter no of columns ");
        int c2 = sc.nextInt();

        // declare 2nd matrix
        int[][] two = new int [r2][c2];

        // travarse 2nd matrix 
        System.out.println("enter elements for 1st matrix");
        for(int i=0; i<two.length; i++) // fill row
        {
            for(int j=0; j<two[0].length; j++) // fill column
            {                
                two[i][j] = sc.nextInt(); // input of 2nd matrix
            }
        }

        // if 1st matrix Column & 2nd matrix Row is not same then matrix is invalid
        if(c1 != r2){
            System.out.println("Invalid input");
            return;
        }

        // if 1st matrix Column & 2nd matrix Row is same then matrix is valid
        // declare resultantnt matrix means ans of 1st and 2nd matrix
        int[][] resultant  = new int[r1][c2];  // size of this matrix is 1st matrix row and 2nd matrix column

        // travarse resultant matrix 
        for(int i=0; i<resultant.length; i++) // row
        {
            for(int j=0; j<resultant[0].length; j++) // column
            {
                for(int k=0; k<c1; k++) // in place of c1 i can also write r2 // explanation in copy
                {
                    resultant [i][j] += one[i][k] * two[k][j];
                }
            }
        }

        System.out.println("matrix multiplication is");
        
        // //  display reultant matrix with for each loop
        // for(int x[] : resultant){
        //     for(int y : x){
        //         System.out.print(y + " ");
        //     }
        //     System.out.println();
        // }

        // display reultant matrix with for loop
        for(int i=0; i<resultant.length; i++) { // row
            for(int j=0; j<resultant[0].length; j++) { // column
                System.out.print(resultant[i][j] + " ");
            }
            System.out.println();
        }
    }
}



// enter no of rows 
// 2
// enter no of columns 
// 2
// enter elements for 1st matrix
// 12
// 23
// 45
// 65
// enter no of rows 
// 2
// enter no of columns 
// 2
// enter elements for 1st matrix
// 1
// 0
// 0
// 1
// matrix multiplication is
// 12 23
// 45 65