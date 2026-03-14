public class O1_Display_elements{

    public void display(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main function
    public static void main(String[] args) {

        O1_Display_elements arrElement = new O1_Display_elements();
        
        arrElement.display(new int[] {5, 1, 3, 78, 17});
    }
}
