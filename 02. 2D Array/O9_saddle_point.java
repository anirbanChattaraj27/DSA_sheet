import java.util.Scanner;

public class O9_saddle_point{

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

        // saddle point
        for(int i=0; i<arr.length; i++) // travarse in each row
        {
            int svj = 0; // svj = smallestValueOfJ
            for(int j=1; j<arr[0].length; j++) // checking clumn wise 
            {
                if(arr[i][j] < arr[i][svj]) // if value is least then assign it to svj
                {
                    svj = j;
                }
            }
            
            // here taravel in that column which value is smaaler 
            boolean flag = true;
            for(int k=0; k<arr.length; k++){
                if(arr[k][svj] > arr[i][svj]){ // here comparing least value with every element in its column
                    flag = false; // if greater value is found then make it false
                    break;
                }
            }

            if(flag == true){ // if no greater value is found then that row value is greater
                System.out.println(arr[i][svj]);
                return;
            }
        }
        System.out.println("no saddle point found");
    }
}



// Enter total no of rows 
// 4
// Enter total no of columns 
// 4
// enter matrix elements
// 11 12 13 14
// 15 16 17 18
// 19 20 21 22
// 23 24 25 26
// Display:
// 23