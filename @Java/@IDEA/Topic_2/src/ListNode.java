/*给你两个 非空 的链表，表示两个非负的整数。
它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode v1 = l1, v2 = l2;
        int length1 = 0, length2 = 0;
        while (v1 != null) {
            v1 = v1.next;
            length1++;
        }
        while (v2 != null) {
            v2 = v2.next;
            length2++;
        }

        v1 = l1;
        v2 = l2;
        ListNode head = new ListNode(0);
        ListNode result = head;
        for (int i = 0; i < length1 && i < length2; i++) {
            int sum = v1.val + v2.val + result.val;
            result.val = sum % 10;
            int carry = sum / 10;
            if (v1 != null || v2 != null || carry != 0) {
                result.next = new ListNode(carry);
            }
            v1 = v1.next;
            v2 = v2.next;
            result = result.next;
        }

        if (length1 > length2) {
            for (int i = length2; i < length1; i++) {
                int sum = v1.val + result.val;
                result.val = sum % 10;
                int carry = sum / 10;
                if (v1 != null || v2 != null || carry != 0) {
                    result.next = new ListNode(carry);
                }
                v1 = v1.next;
                result = result.next;
            }
        } else if (length2 >length1) {
            for(int i = length1; i < length2; i++) {
                int sum = v2.val + result.val;
                result.val = sum % 10;
                int carry = sum / 10;
                if (v1 != null || v2 != null || carry != 0) {
                    result.next = new ListNode(carry);
                }
                v2 = v2.next;
                result = result.next;
            }

        }
        // Trim any extra node at the end if it's 0
        if (result.val == 0 && result.next == null && head != result) {
            // Find the second to last node
            ListNode temp = head;
            while (temp.next != result) {
                temp = temp.next;
            }
            temp.next = null;
        }

        return head;
    }
}