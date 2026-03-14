/*
 * https://prepinsta.com/java-program/find-out-the-quadrant-in-which-the-given-co-ordinate-lie/
 */



/*
    Get value of x & y
    If ( x>0 and y>0 ) First Quadrant
    If ( x<0 and y>0 ) Second Quadrant
    If ( x<0 and y<0 ) Third Quadrant
    If ( x>0 and y>0 ) Fourth Quadrant
    If ( x=0 and y=0 ) Origin
    If ( x!=0 and y=0 ) x-axis
    If ( x>0 and y>0 ) y-axis
*/

public class O3_quadrant {
    public static void main(String[] args) {

        int x=-3, y=-33;

        //find true condition of first quadrant
        if(x>0 && y>0)
            System.out.println("Quadrant I");   

        //find second quadrant
        else if(x<0 && y>0)
            System.out.println("Quadrant II");

        //To find third quadrant
        else if(x<0 && y<0) System.out.println("Quadrant III"); 

        //To find Fourth quadrant 
        else if (x > 0 && y < 0)
            System.out.println("Quadrant IV");
            
        //To find dose not lie on origin
        else if (x == 0 && y == 0)
            System.out.println("Origin");
            
        //On x-axis
        else if (y==0 && x!=0)
            System.out.println("x-axis");
            
        //On y-axis
        else if (x==0 && y!=0)
            System.out.println("y-axis");

    
    }
}
