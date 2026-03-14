import java.util.*;

public class O6_move_negetive_elements_one_side_of_array {

    public static void display(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }

    public static void moveNegetives(int arr[]){
        int j = 0;
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i] >= 0 && arr[j] < 0){
        //         int temp = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = temp;
        //     }

        //     if(arr[j] >= 0)
        //         j++;
        // }

        int i=0;
        while(i < arr.length){ // for (int i = 0; i < arr.length; i++)
            if(arr[i] < 0){
                swap(arr, i, j);;
                i++;
                j++;
            }
            else{
                i++;
            }
        }
    }

    static void usingLIST(int arr[]){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 0){
                list1.add(arr[i]);
            }
            else{
                list2.add(arr[i]);
            }
        }

        for(int i=0; i<list1.size(); i++){
            System.out.print(list1.get(i) + " ");
        }
        for(int i=0; i<list2.size(); i++){
            System.out.print(list2.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {-78, -78, -9, 12, 56, 0, 1, -5,};
        moveNegetives(arr);
        display(arr);

        System.out.println();

        usingLIST(arr);

    }
}