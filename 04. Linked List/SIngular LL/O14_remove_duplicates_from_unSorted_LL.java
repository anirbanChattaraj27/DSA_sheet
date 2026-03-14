// problem link --> https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1

// 3 approches -->
// 1. use 2 loops... 1 will travarse 0 to size aand 2nd loop starts from i+1 to end and compare elements... time-->O(n^2) & space-->O(1)
// sort LL then use sorted remove duplicates approch... time-->O(nlogn) & space-->O(1)
// using hashSet --> time-->0(n) & space -->0(n)

public class O14_remove_duplicates_from_unSorted_LL {
    //Function to remove duplicates from unsorted linked list.
	public Node removeDuplicates(Node head)  
    { 
        //using set to store already seen values in list. 
        HashSet<Integer> hs = new HashSet<>(); 
      
        //using two pointers one of which stores first node other null.
        Node current = head; 
        Node prev = null; 
        
        //traversing over the linked list.
        while (current != null)  
        { 
            int curval = current.data; 
              
            //if data at current node is already present in set, we skip the 
            //current node and store the node next to current in link of prev. 
            if (hs.contains(curval)) { 
                prev.next = current.next;
                //deleting current node which contains duplicates. 
                current=null;
            }
            
            //else we just insert the data at current node in set and update 
            //prev to the current node.
            else { 
                hs.add(curval); 
                prev = current;
            }
            //updating current to the next node of prev.
            current = prev.next; 
        } 
        return head;
    } 
}

