/* ****** */
// NOTE: reverse array[] using Collections.reverseOrder()

/*
        Input :arr1[4] = [10, 30, 40, 20]
               arr2[4] = [2, 4, 5, 1]
        Output : 230
        Explanation : 10*5 + 20*4 + 30*2 + 40*1 = 230

        ALGORITHM->
        Sort the first array in ascending order,
        Sort the second array in descending order.
        Declare a variable say product = 0.
        Run a loop from index 0 to n
        Set product += (arrr1[i]*arr2[i])
        After complete iteration print product.
*/
import java.util.*;
public class O25_scaler_product_of_2nums {
    public static void main(String[] args) {
        Integer arr1[] = { 1, 2, 6, 3, 7 };
        Integer arr2[] = { 10, 7, 45, 3, 7 };
        int n = arr1.length;

        // Sort arr1 in ascending order
        Arrays.sort(arr1);

        // Sort arr2 in descending order
        Arrays.sort(arr2, Collections.reverseOrder());

        int product = 0;
        for (int i = 0; i < n; i++)
            product += arr1[i] * arr2[i];

        System.out.print(product);
    }
}
