public class O1_HCF {

    public static void main(String[] args) {

        /* HCF */
        int num1 = 8, num2 = 2, hcf = 0;

        for (int i = 1; i <= num1 || i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                hcf = i;
        }
        
        System.out.println("The HCF: " + hcf);

        /* LCM */
        int lcm = (num1*num2) / hcf; // formula: lcm = (n1 * n2) / HCF
        System.out.println("The LCM is " + lcm);

    }

}
