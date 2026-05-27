// https://www.geeksforgeeks.org/dsa/pair-with-given-product-set-1-find-if-any-pair-exists/
// hash and 2 pointer

public class O13_Pair_with_given_product {
    public int numRescueBoats(int[] people, int target) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // If the lightest and heaviest can share, move the left pointer
            if (people[left] + people[right] <= target) {
                left++;
            }
            // The heaviest person always gets a boat
            right--;
            boats++;
        }        
        return boats;
    }
}
