// https://leetcode.com/problems/merge-two-sorted-lists/submissions/
// https://www.youtube.com/watch?v=Xb4slcp1U38

public class O21_merge_two_LL{
    
    public Node mergeTwoLists(Node list1, Node list2) {

        if(list1 == null) return list1; // if list1 is empty
        if(list2 == null) return list2; // if list2 is empty
        
        if(list1.val > list2.val){ // if list1's value > lis2's valiue then swap them
            Node temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        Node res = list1; // result pointes on list1

        while(list1 != null && list2 != null){ // loop going until lis1 & list2 not null

            Node tmp = null; // tmp points null

            while(list1 != null && list1.val <= list2.val){ // list1 is not null and list1's value < list2's value // this loop is only for list1
                tmp = list1; // temp previously points on null now points on list1
                list1 = list1.next; // list1 moves to next node of list1
            }

            // if list2 > list1  then, temp's next points to list2
            tmp.next = list2; 
            
            // so now list2 becomes smaller bcz temp's next points to list2 node so swap list1 nd list2
            // swap
            Node temp = list1;
            list1 = list2;
            list2 = temp;
        }
        return res;  
    }

    public static void main(String[] args) {
        
    }
}