public class O7_alphaNumeric {

    public static boolean isAlphaNumeric2(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

    public static boolean isAlphaNumeric3(String s){
        s=s.toLowerCase();

        if(s.length() <=0){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "jhg";
        System.out.println("IsAlphaNumeric2: " + isAlphaNumeric2(s));
        System.out.println("IsAlphaNumeric3: " + isAlphaNumeric3(s));
    }
}
