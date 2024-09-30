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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(2);
        ListNode t = dummy;
        int carry = 0;

        while(temp1 != null && temp2 != null){
            if(temp1.val + temp2.val + carry < 10){
                ListNode newNode = new ListNode(temp1.val + temp2.val + carry);
                t.next = newNode;
                temp1 = temp1.next;
                temp2 = temp2.next;
                t = t.next;
                if(carry == 1){
                    carry = 0;
                }
            }
            else if(temp1.val + temp2.val + carry >= 10){
                ListNode newNode = new ListNode((temp1.val + temp2.val + carry)%10);
                t.next = newNode;
                temp1 = temp1.next;
                temp2 = temp2.next;
                t = t.next;
                carry = 1;
            }
        }
        while(temp1 != null){
            if(temp1.val + carry < 10){
                ListNode newNode = new ListNode(temp1.val +  carry);
                t.next = newNode;
                temp1 = temp1.next;
                t = t.next;
                if(carry == 1){
                    carry = 0;
                }
            }
            else if(temp1.val + carry >= 10){
                carry = 1;
                ListNode newNode = new ListNode((temp1.val + carry)%10);
                t.next = newNode;
                temp1 = temp1.next;
                t = t.next;
            }
        }
        while(temp2 != null){
            if(temp2.val + carry < 10){
                ListNode newNode = new ListNode(temp2.val +  carry);
                t.next = newNode;
                temp2 = temp2.next;
                t = t.next;
                if(carry == 1){
                    carry = 0;
                }
            }
            else if(temp2.val + carry >= 10){
                carry = 1;
                ListNode newNode = new ListNode((temp2.val + carry)%10);
                t.next = newNode;
                temp2 = temp2.next;
                t = t.next;
            }
        }
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            t.next = newNode;
            t = t.next;
        }
        return dummy.next;
    }
}