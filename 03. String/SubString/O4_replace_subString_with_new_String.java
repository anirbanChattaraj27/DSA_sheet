// remove subString with new String
// replace subString with new String


// remove all comments then execute
    //   Take a string input from user and store it in a variable called “s1” 
    //   After that take a string input from user to replace string and store it in a variable called as “oldString” 
    //   Take new string input from user to replace that old string with new String and store this value in a variable called as “newString”
    //   After that user replace() method to replace old string with new string




import java.util.*;

public class O4_replace_subString_with_new_String {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter a String : ");
        String s1 = sc.nextLine();
    
        System.out.print("Enter the String to be replaced : ");
        String oldString = sc.nextLine();
    
        System.out.print("Enter the new String : ");
        String newString = sc.nextLine();
    

        
        String replaceString = s1.replace(oldString, newString);
    
        System.out.println("New String is :" + replaceString);
    }
}



// Enter a String : anirban
// Enter the String to be replaced : ban
// Enter the new String : rick
// New String is :anirrick
