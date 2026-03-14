public class O1_count_2Strings_have_same_char_in_same_index {

    // using forLoop
    static void usingFOR(String s1, String s2){
        int count = 0;

        for(int i=0; i<s1.length(); i++){  // as i have same length in 2 string
            if(s1.charAt(i) == s2.charAt(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    static void usingWHILE(String s1, String s2){
        int i = 0;  int j = 0;
        int count = 0;

        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                count++;
            }
            i++; j++;
            
        }
        System.out.println(count);
    }

    public static void main(String[] args) {    
        int arr[] = {12, 122, 225, 3353, 5445, 2, 333, 35333, 22222};
        
        String s1 = "chance";
        String s2 = "choicE";  //o/p->4

        String ss1 = "123345";
        String ss2 = "145323"; // o/p->2 [1,3 are in same pos]
        usingFOR(ss1, ss2);
        usingWHILE(ss1, ss2);
        usingFOR(s1, s2);
        usingWHILE(s1, s2);
    }
}
