import java.io.CharArrayReader;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class O15_reverse_each_words {
    
    public static void main(String[] args) {
        
        String str = "Java Program to print a string";
        System.out.println("original string is: " + str);

        String temp = ""; 
        String[] words = str.split(" ");

        for(String x : words){ 

            String rev = ""; 
            
            for(int i=x.length()-1; i>=0; i--){  
                rev = rev + x.charAt(i);  
            }
            temp = temp + rev + " "; 
        }
        System.out.println("reverse word is: " + temp);
    }
}

