/*
Example 1:
Input:jobs = [3, 1, 4, 2, 5]
Output: 4           
Explanation:  
The first job that will be executed is of duration 1 and the waiting time for it will be 0.
After the first job, the next shortest job with a duration of 2 will be executed with a waiting time of 1.
Following the completion of the first two jobs, the next shortest job with a duration of 3 will be executed with a waiting time of 3 (1 + 2).
Then, the job with a duration of 4 will be executed with a waiting time of 6 (1 + 2 + 3).
Finally, the job with the longest duration of 5 will be executed with a waiting time of 10 (1 + 2 + 3 + 4). Hence, the average waiting time is calculated as (0 + 1 + 3 + 6 + 10) / 5 = 20 / 5 = 4.
*/

import java.util.*;

public class O33_shortest_job_first {
 
    public float calculateAverageWaitTime(int[] jobs) {
        // Sort jobs in ascending order (Shortest Job First)
        Arrays.sort(jobs);

        float waitTime = 0;  // Stores cumulative waiting time
        int totalTime = 0;   // Tracks elapsed execution time
        int n = jobs.length; // Number of jobs

        // Iterate through each job
        for (int i = 0; i < n; i++) {
            waitTime += totalTime;  // Add current total time to waiting time
            totalTime += jobs[i];   // Execute current job
        }

        // Return the average waiting time
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};

        System.out.print("Array Representing Job Durations: ");
        for (int job : jobs) {
            System.out.print(job + " ");
        }
        System.out.println();

        O33_shortest_job_first sjf = new O33_shortest_job_first();
        float ans = sjf.calculateAverageWaitTime(jobs);

        System.out.println("Average waiting time: " + ans);
    }
}