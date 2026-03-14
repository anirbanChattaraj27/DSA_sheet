// NOTE: get nuerical vlaue of string character 🎇🎆🎈

public class O24_sum_of_numbers {
    
    public static void main(String[] args) {
        String s ="4n50";
        int sum=0;

        for (int i = 0; i < s.length(); i++) {

           if(Character.isDigit(s.charAt(i))){ // 🎇🎆🎈
               sum = sum+Character.getNumericValue(s.charAt(i)); // 🎇🎆🎈
           }
        }
        System.out.println("Sum of all the digit present in String : "+sum);
    }

    // public static void main(String[] args) {
    //     String str="4Anirban55rick45";
    //     int sum=0;

    //     for(int i=0;i<str.length();i++){ 
    //         if(str.charAt(i)>='0' && str.charAt(i)<='9'){
    //             sum+=(str.charAt(i)-'0');
    //         }
    //     }
    //     System.out.println("Sum of all digits " +sum );
    // }
    
}


// /* why did i use -'0' */
/*
 * char c = '3';
 * int i = c - '0';
In this case, c is the character '3', which has an ASCII value of 51. When you subtract '0' from '3', you get 51 - 48 = 3, which is the numeric value of the digit '3'.
This technique can be used to convert the character representation of a digit to its numeric value, as is done in the code you provided.
I hope this helps to clarify the purpose of the -'0' expression in the code. Let me know if you have any other questions.
 */
