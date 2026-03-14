
public class O2_print_1_to_N {
    
    // ERROR
    // 1 to N
    public static void increase(int N, int i){

        // int i=0;
        if(i > N) {
            return;
        }
        else{
            System.out.print (i + " ");
            increase(N, i+1);
        }
    }
    
    // correct
    // N to 1
    static void decrease(int N){
        
        // If N is less than 1 then return function
        if (N <= 0){
            return;
        }
        else{
            System.out.print(N + " ");
            decrease(N - 1);
        }
    }

    public static void main(String[] args){
        
        int num = 10;
        
        increase(num, 1);
        System.out.println();
        decrease(num);
    }
}