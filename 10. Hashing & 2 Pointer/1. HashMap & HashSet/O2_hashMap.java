 import java.util.*;

public class O2_hashMap{
    public static void main(String[] args) {

        HashMap < Integer, String > myhashmap = new HashMap <>();

        // Add elements to the map
        myhashmap.put(1, "Chennai");
        myhashmap.put(2, "Trichy");
        myhashmap.put(3, "Kanpur");
        myhashmap.put(4, "Coimbatore");
        myhashmap.put(5, "Bhopal");
        System.out.println();

        System.out.println("**********print using println*********");
        System.out.println(myhashmap);
        System.out.println(myhashmap.size());
        System.out.println();

        System.out.println("**********loop inside map********");
        for (Map.Entry < Integer, String > x: myhashmap.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue()); // for getting key write getKey() and for getting value write getValue()
        }
        System.out.println();

        System.out.println("************checking key is present or not***********");
        if (myhashmap.containsKey(1))
            System.out.println("Contains 1: " + myhashmap.get(1));
        else
            System.out.println("Doesnt contain 1 key");
            System.out.println();

        System.out.println("***********removing key1 and size of hashMap************");
        myhashmap.remove(1);
        System.out.println(myhashmap);
        System.out.println(myhashmap.size());
        System.out.println();

        System.out.println("************checking value is present or not***********");
        if (myhashmap.containsValue("Bhopal"))
            System.out.println("VALUE IS Bhopal contains in MAP");
        else
            System.out.println("Does Not contain Bhopal");
            System.out.println();

        System.out.println("***********print keys************");
        for (Integer i: myhashmap.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("***********print values************");
        for (String i: myhashmap.values()) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("************print key and value***********");
        for (Integer i: myhashmap.keySet()) {
            System.out.println("key: " + i + " value: " + myhashmap.get(i));
        }
        System.out.println();

        System.out.println("************clear hashMap***********");
        myhashmap.clear();
        System.out.println(myhashmap.isEmpty());
    }
}