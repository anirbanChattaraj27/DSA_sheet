import java.util.Scanner;

public class IV_Largest_smallest {

    public static void main(String[] args)
    {
        int n, i;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no of element: ");
        n = s.nextInt();

        int a[] = new int [n];
        for(i=0; i<n; i++){
            System.out.print("Enter the element "+(i+1)+": ");
            a[i] = s.nextInt(); 
        }

        int max = a[0];
        int min = a[0];

        for(i=0; i<n; i++)
        {
            if(a[i] > max)
                max = a[i];

            if(a[i] < min)
                min = a[i];
        }
        System.out.println("min element is: " + min);
        System.out.println("max element is: " + max);
    }
}
