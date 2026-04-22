public class O2_decimal_to_octal {

    public static void main(String args[]) {

        // decimal to octal
        int Decimal = 45;
        int Octal[] = new int[20]; // integer array for storing octal digits
        int i = 0;

        while (Decimal > 0) {
            int remainder2 = Decimal % 8;
            Octal[i++] = remainder2;
            Decimal = Decimal / 8;
        }

        // printing result
        System.out.print("decimal to Octal number : ");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(Octal[j]);
        }

 
        System.out.println();

        
        // octal to decimal
        int octal = 512;
        int decimal = 0;
        int n = 0;// Declare variable to use in power

        while (octal > 0) {
            int remainder = octal % 10;
            decimal += remainder * Math.pow(8, n);
            octal = octal / 10;
            n++;    
        }
        System.out.println("octal to Decimal number : "+decimal); 



        
    }
}
