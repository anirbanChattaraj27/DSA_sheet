public class O29_amicable {
    public static void main(String[] args) {
        int num1 = 220;
        int num2 = 284;

        if(fun(num1) == num2 && fun(num2) == num1){
            System.out.println("its amicable pair");
        }
        else{
            System.out.println("not a amicable pair");
        }
    }

    static int fun(int n){
        int sum = 0;

        for(int i=1; i<n; i++){
            if(n % i == 0){
                sum = sum + i;
            }
        }
        return sum;
    }
}
