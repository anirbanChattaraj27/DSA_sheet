import java.util.Scanner;


public class II_Largest_element_in_array {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter how many no u want to print: ");
        n = s.nextInt();

        int a[] =  new int[n];
        for(int i=0; i<n; i++){
            a[i] = s.nextInt();
        }

        int max = a[0];

        for(int i=0; i<n; i++) {
            if(a[i] > max)
                max = a[i];
        }
        System.out.println("Maximum no is: " + max);

    }
}

