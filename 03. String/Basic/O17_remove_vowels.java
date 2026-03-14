// link =   animation -> https://www.youtube.com/watch?v=ZywpTXIktrk&list=PL6Zs6LgrJj3vFnWWSmxzJv4_Ty1NBRd1-&index=9
// implementation     -> https://www.youtube.com/watch?v=fQKzTodd0A8&list=PL6Zs6LgrJj3vFnWWSmxzJv4_Ty1NBRd1-&index=10

public class O17_remove_vowels {
        public static String removeVowels(String str) {

                String remove = str.replaceAll("[aeiouAEIOU]", "@");
                return remove;
        }

        public static void main(String[] args) {
                String S = "AanirbAn ChattarAj";
                System.out.println(removeVowels(S));
        }

}