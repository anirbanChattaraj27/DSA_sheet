// capitalize Each word first letter of a sentence


public class O31_capitalize_Each_word_first_letter {
    public static void main(String[] args) {
	    String str = "pencil programmer ab xyz f";
    
	    //Split sentence into words
	    String words[]=str.split("\\s");
        String newString ="";
        
        for(String w: words){ 
            String first = w.substring(0,1); //First Letterzz
            String rest = w.substring(1); // Rest of the letters
            
            //Concatenete and reassign after
            //converting the first letter to uppercase
            newString+=first.toUpperCase()+ rest+ " ";
        }

        //trim to remove the last redundant blank space
        System.out.println(newString.trim());
	}
}
