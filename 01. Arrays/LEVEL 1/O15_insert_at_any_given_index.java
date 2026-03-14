import java.util.Scanner;

public class O15_insert_at_any_given_index {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter how many elements u want to print");
        int n = s.nextInt();
        int a[] = new int [n + 1];

        System.out.println("Enter " + n + " elements");
        for(int i=0; i<n; i++)
        {
            a[i] = s.nextInt();
        }

        System.out.println("Enter the element u want to insert: ");
        int z = s.nextInt();

        System.out.println("in which position u want to inser number");
        int pos = s.nextInt();

        System.out.println("Elements are");
        for(int i=n; i>=pos; i--)
        {
            a[i] = a[i-1];
        }
        a[pos-1] = z;

        for(int i=0; i<=n; i++)
        {
            System.out.println(" " + a[i]);
        }
    }
}




