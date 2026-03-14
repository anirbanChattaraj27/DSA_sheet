
import java.util.Scanner;

public class O10_search_in_sorted_matrix{

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
        System.out.println("Enter which value u want to search:");
        int x = sc.nextInt();

        int i = 0;
        int j = arr[0].length - 1; // j starts from last element of 1st row 

        while(i < arr.length && j>= 0){

            if(x == arr[i][j])
            {
                System.out.println(i);
                System.out.println(j);
                return;
            }

            else if(x < arr[i][j]){
                j--; // if we go to left side of column then values will reduce so j--
            }

            else{
                i++; // if values are greater then go to down side
            }
        }
        System.out.println("KEY IS NOT FOUND");
    }
}


// Enter total no of rows 
// 3
// Enter total no of columns 
// 3
// enter matrix elements
// 11 12 13
// 14 15 16
// 17 18 19
// Enter which value u want to search:
// 13
// 0
// 2