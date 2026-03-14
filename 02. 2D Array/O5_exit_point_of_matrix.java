import java.util.Scanner;

public class O5_exit_point_of_matrix {
    
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
        int direction = 0;
        int i = 0;
        int j = 0;

        // checcking directions
        while(true)
        {
            direction = (direction + arr[i][j]) % 4;

            if(direction == 0){  // while going to east, row(i) is fixed and column(j) increment
                j++;
            }
            else if(direction == 1){ // while going to south, row(i) is increment and column(j) is fixed
                i++;
            }
            else if(direction == 2){ // while going to west, row(i) is fixed and column(j) decrement
                j--;
            }
            else if(direction == 3){ // while going to north, row(i) is decrement and column(j) is fixed
                i--;
            }

            // exit point
            if(i < 0){
                i++;
                break;
            }
            else if(j < 0){
                j++;
                break;
            }
            else if(i == arr.length){
                i--;
                break;
            }
            else if(j == arr[0].length){
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
}





// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 0
// 0
// 0
// 1
// 0
// 0
// 0
// 0
// 1
// 0
// 0
// 1
// 0
// 1
// 1
// 0

// Display:
// 0
// 0


// 💋💋sample i/p && o/p✨✨
// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 0
// 0
// 1
// 0
// 1
// 0
// 0
// 0
// 0
// 0
// 0
// 0
// 1
// 0
// 1
// 0
// Display:
// 1
// 3