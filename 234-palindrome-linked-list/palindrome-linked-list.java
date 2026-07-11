/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;

        // find middle pointer
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow is in middle
        ListNode firstHalf = head;
        ListNode secondHalf = slow;

        ListNode secondHalfReverse = null;

        // reverse the second half node
        while(secondHalf != null) {
            ListNode temp = secondHalf.next;
            secondHalf.next = secondHalfReverse;
            secondHalfReverse = secondHalf;
            secondHalf = temp;
        }

        while(secondHalfReverse != null) {
            if(firstHalf.val != secondHalfReverse.val)
                return false;
            
            firstHalf = firstHalf.next;
            secondHalfReverse = secondHalfReverse.next;

        }
        return true;

    }
}