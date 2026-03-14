// https://practice.geeksforgeeks.org/problems/count-squares3649/1?page=1&category[]=Mathematical&sortBy=submissions

public class O3_count_squars {
    static int countSquares(int N) {
        return ((int)Math.sqrt(N-1));
    }

    public static void main(String[] args) {
        System.out.println(countSquares(100));
    }
}

// 1, 4  are perfect squres bellow 9 so return 2
