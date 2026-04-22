import javax.sound.sampled.ReverbType;

public class O1_reverse_number {
    public static long reverse(int num){

        boolean isNegetive = num < 0;
        if(isNegetive){
            num = num * -1;
        }
        
        long reverse = 0;

        int lastDigit;
        while(num > 0){
            lastDigit = num % 10;
            reverse = reverse*10 + lastDigit;
            num /= 10;
        }

        return isNegetive? reverse * -1 : reverse; 
    }

    public static void main(String[] args) {
        int num = -1234;
 
        System.out.println(reverse(num));
    }
}
