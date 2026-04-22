public class O0_swap {
    public static void main(String[] args) {
        
        int a = 45, b= 25;

        // using 3rd variable
        int temp = a;
        a = b; // a =  25
        b = temp; // b = 45
        System.out.println("After swapping: value of a is " + a + ", and value of b is " + b);

        // without using 3rd varable
        a = a+b;
        b = a-b; // b = 45
        a = a-b; // a = 25

        System.out.println("After swapping: value of a is " + a + ", and value of b is " + b);
    }
}
