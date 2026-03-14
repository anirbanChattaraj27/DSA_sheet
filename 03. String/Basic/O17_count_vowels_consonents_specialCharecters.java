// count vowels consonents special Charecters

public class O17_count_vowels_consonents_specialCharecters{

    public static void main(String args[]){
        
        String str = "anirban  is a programmer 779-65+0";
        str = str.toUpperCase();
        char ch[] = str.toCharArray();

        int vowel = 0;
        int consonent = 0;
        int number = 0;
        int specialChar = 0;

        for(int i=0; i<ch.length; i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){

                if(ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'O' || ch[i] == 'I' || ch[i] == 'U'){
                    vowel++;
                }
                else{
                    consonent++;
                }
            }

            else if(ch[i] >= '0' && ch[i] <= '9'){
                number++;
            }
            
            else{
                specialChar++; // specialChars are nothing but speces or syboml
            }
            
        }

        System.out.println(vowel);
        System.out.println(consonent);
        System.out.println(number);
        System.out.println(specialChar);
    }
}