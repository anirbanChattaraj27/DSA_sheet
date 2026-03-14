public class IV_sum_of_elements {
    public static void main(String[] args) {
        
        int a[] = {12 , 25, 13, 50};
        int sum = 0;

        for(int x : a)
        {
            sum = sum+x;
        }
        System.out.println(sum);
    }
}
