// copy: 4

import java.util.*;

public class O4_ship_packages_within_D_days {

    static int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + load > cap) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    static int leastWeightCapacity(int[] weights, int d) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);

            if (numberOfDays <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        int result = leastWeightCapacity(weights, days);
        System.out.println(result);
    }
}
