public class O7_toggle_case {

    public static String checkCase(String str){
        String str1 = "";  // here i will store toggled charecters
        
        for(int i=0; i<str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))){
                str1 += Character.toLowerCase(str.charAt(i));
            }
            else{
                str1 += Character.toUpperCase(str.charAt(i));
            }
        }
        return str1;
    }

    public static void main(String[] args) {
        String S = "AnIrBaN ChAtTaRaJ";
        System.out.println(checkCase(S));
    }
} 
