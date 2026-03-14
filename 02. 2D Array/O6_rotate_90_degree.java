import java.util.Scanner;


public class O6_rotate_90_degree {

    public static void display(int[][] arr){
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

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

        // transpose
        for(int i = 0; i< arr.length; i++){
            for(int j = i; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse
        for(int i=0; i<arr.length; i++){
            int leftIndex = 0;
            int rightIndex = arr[i].length-1;

            while(leftIndex < rightIndex)
            {
                int temp = arr[i][leftIndex];
                arr[i][leftIndex] = arr[i][rightIndex];
                arr[i][rightIndex] = temp;

                leftIndex++;
                rightIndex--;
            }
        }
        display(arr);
    }
}


// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12
// 13
// 14
// 15
// 16

// Display:
// 13 9 5 1 
// 14 10 6 2
// 15 11 7 3
// 16 12 8 4