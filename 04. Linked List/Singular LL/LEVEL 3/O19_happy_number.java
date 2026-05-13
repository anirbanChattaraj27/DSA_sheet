/* https://leetcode.com/problems/happy-number/ */

/*
    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    

    Example 1:

    Input: n = 19
    Output: true

    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    62 + 82 = 100
    1^2 + 0^2 + 0^2 = 1

    Example 2:

    Input: n = 2
    Output: false
 */

/*
    this qs says nothing but LL cycle like, at first input a number(19) then separate number (1^2 + 9^2) then sum of them (82) then again separete them in this way it will goes on when 1 will come return tru if 1 wjill not come then definately 1 number will come which i have calculated erlyer means it'll going in a cyecle so it is nothing bt  LL cycle 
*/

public class O19_happy_number {

    Node head;  // here we create head
    private int size;

    // creating node
    public class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // diaply LL 
    public void display(){
        if (head == null){
            System.out.println("Empty list");
            return;
        }

        Node lastNode = head;
        while (lastNode != null) {
            System.out.print(lastNode.data + " --> ");
            lastNode = lastNode.next;
        }
        System.out.println("NULL");
    }

    // addding at last of the node
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    // happy or not
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);  // find square of number and moving 1 step
            fast = findSquare(findSquare(fast));  // finding suare of a number and moving 2 steps
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    // separate number and find square of it
    public static int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }


    public static void main(String[] args) {
        O19_happy_number list = new O19_happy_number();

        System.out.println(list.isHappy(19));
        
    }
}

