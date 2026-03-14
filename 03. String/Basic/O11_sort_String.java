import java.util.Arrays;

public class O11_sort_String { 

    public static String sorting(String str){
        String str2 = "";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        for(int i=0; i<ch.length; i++){
            str2 += ch[i];
        }
        return str2;
    }

    public static void main(String[] args) {
        String str = "the quick brown fox jumps over the lazy dog";
 
        char[] arr = str.toCharArray();
        char temp;

        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(new String(arr));

        // approch 2
        String str1 = "the lazy clam brown fox jumps over the dog";

        char[] charArray = str1.toCharArray();
        Arrays.sort(charArray);
        System.out.println(charArray);
        System.out.println(sorting(str1));

        
    }
}
