/* try to UNDERSTAND this prblm later, STRIVER 2 pointer video lecture 5 */

// code with explanation: https://leetcode.com/problems/fruit-into-baskets/solutions/3153809/clean-codes-full-explanation-hashtable-c-java-python3/
// prblm: https://leetcode.com/problems/fruit-into-baskets/description/
// * I have to pick 1 type of fruit from basket
// * I can not put more than 1 type of fruit in 1 basket
// * I have 2 basket and iside that i have to put maximum fruit of any 2 type BUT,
//   I can not put randomly I have to pick 2 Unique type fruit in the same window
//   i.e. 1 2 2 2 3 3 4 5 5 5 6 7
//   222 33 count is 5 this is a window THIS IS ALLOWED
//   222 555 count is 6 but, different window so NOT ALLOWED
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class O2_fruits_into_basket {

    public int totalFruit(int[] arr) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int l = 0, r = 0; r < arr.length; ++r) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                ++l;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    // leetcode sol. || 2 pointer || sliding window
    public int totalFruit2 (int[] fruits) {
        Set<Integer> types = new HashSet<>();
        int ans = 0;
        int start = 0;
        for (int end = 0; end < fruits.length; end++) {
            int fruitType = fruits[end];
            types.add(fruitType);
            if (types.size() > 2) {
                int prevFruitType = fruits[end - 1];
                int i = end - 1;
                while (true) {
                    if (fruits[i] != prevFruitType) {
                        types.remove(fruits[i]);
                        i++;
                        break;
                    } else {
                        i--;
                    }
                }
                start = i;
            }
            ans = Math.max(end - start + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        O2_fruits_into_basket solution = new O2_fruits_into_basket();
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 6, 7};
        System.out.println("Max number of fruits: " + solution.totalFruit(arr)); // Output: 4
    }
}
