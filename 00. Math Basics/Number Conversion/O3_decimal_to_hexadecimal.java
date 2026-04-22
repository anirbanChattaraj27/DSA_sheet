public class O3_decimal_to_hexadecimal {

    public static void decimalTOhexadecimal(int empty) {

        int decimalNumber = 45598745; // decimal number to convert to hexadecimal
        String hexadecimalString = "";

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;

            if (remainder < 10) { // if the remainder is less than 10, append it as a digit to the hexadecimal string
                hexadecimalString = remainder + hexadecimalString; 
            } 

            else { // if the remainder is greater than or equal to 10, append the corresponding  letter to the hexadecimal string
                
                char hexChar = (char) ('A' + remainder - 10);
                hexadecimalString = hexChar + hexadecimalString;
            }

            decimalNumber /= 16;
        }

        System.out.println("Hexadecimal: " + hexadecimalString);

    }

    public static void hexadecimalTOdecimal(int empty) {

        String hex = "C9";
        System.out.println("hexadecimal TO decimal: " + convert(hex));
    }

    static int convert(String hex) {

        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d = digits.indexOf(c);
            val = 16 * val + d;
        }
        return val;
    }

    public static void main(String[] args) {

        int empty = 0; // binary number to convert to decimal

        decimalTOhexadecimal(empty);
        hexadecimalTOdecimal(empty);

    }
}
