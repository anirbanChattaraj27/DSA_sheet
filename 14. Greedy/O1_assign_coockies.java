// https://leetcode.com/problems/assign-cookies/description/
/*
    to satisfy child 3[idx=2] it must have cookie >= 3
    1 cookies can be assign 1 child
    maximum no. of child should get the cookies, retutn count

    g = 1 5 3 3 4
    s = 4 2 1 2 1 3
    o/p: 3
    logic: sort 2 array and compare them and count them when condition satisfies

*/

import java.util.*;

public class O1_assign_coockies {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int i=0, j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(s[j] >= g[i]){
                count++;
                i++; // can't do j++ here
            } 
            j++; // can't do i++ here       
        }
        return count; 
    }

    public static void main(String[] args) {
        int arr1[] = {1, 5, 3, 3, 4};
        int arr2[] = {4, 2, 1, 1, 2, 3};

        System.out.println(findContentChildren(arr1, arr2));
    }
}

