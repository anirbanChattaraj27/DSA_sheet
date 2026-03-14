// if root of floor and ceil value is same then number has perfect square
// 49 -> sqrt(49) is 7 and 7 so it is perfect squre floor and ceil are 7, 7
// 68 -> floor and ceil of it is 8, 9 and sqr of them is not same number so not a 

public class O24_perfect_square {
    static boolean isPerfectSquare(int x) {
        

        int squareROOT = (int) Math.sqrt(x);

        return ((squareROOT * squareROOT) == x);
    
        // return false;
    }

    static void isPerfectSquare2 (int n) {

        if (Math.ceil((double) Math.sqrt(n)) == Math.floor((double) Math.sqrt(n))) {
            System.out.print("True");
        } 
        else {
            System.out.print("False");
        }
    }

    public static void main(String[] args) {
        int x = 84;

        if (isPerfectSquare(x))
            System.out.print("True");
        else
            System.out.print("False");
    }
}
