public class O5_max_number_of_handshakes {
    public static void main(String[] args) {
        //fill the code
        int num = 10;
    
        int total = num * (num-1) / 2; // Combination nC2
            System.out.println("For "+ num +" people there will be " +total+" handshakes");
    }
}
