// leetcode 230

// Kth smallest element
// Kth largest element
/*
Input: root = [3,1,4,null,2], k = 1
Output: 1 [1 is the smallest among others]
*/
public class O4_kth_element2 {

    int count = 0;
    int ans = -1;

    public int kthSmallest(O5_vertical_travarsal root, int k) {
        inorder(root, k);
        return ans;
    }

    void inorder(O5_vertical_travarsal node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            ans = node.val;
            return;
        }

        inorder(node.right, k);
    }
}