public class O1_sum_n_numbers{

    // functional recursion
    public int fun(int n){
        if(n<=1) return n;
        else{
            return n+fun(n-1);
        }
    }

    public int fun2(int n){
        if(n>0) {
            return n+fun(n-1);
        }
        else{
            return 0;
        }
    }
    
    // functional and parameterzied call
    public int fun3(int n, int i){
        if(i < 1) {

            // i can print here directly also
            // System.out.println(n);          
            return n;
        }
        else{
            return fun3(n+i, i-1);
        }
    }


    public static void main(String[] args){

        O1_sum_n_numbers n = new O1_sum_n_numbers();

        System.out.println(n.fun(6));

        System.out.println(n.fun2(6));

        System.out.println(n.fun3(0, 6));
    }
}