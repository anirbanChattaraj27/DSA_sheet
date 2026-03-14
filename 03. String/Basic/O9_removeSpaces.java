public class O9_removeSpaces {

    public static String removeSpaces(String str) {
        String remove = str.replaceAll(" ", "");
        return remove;
    }

    public static void main(String[] args){
        String S = "AnI rBaN Ch   AtTa RaJ";
        System.out.println(removeSpaces(S));
    }

}
