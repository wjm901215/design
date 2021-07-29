package com.spiderman.dataststructure.week1;

/**
 * 链表反转
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0..0: com.spiderman.dataststructure.week1.ResverLink,v 0.1 1/30/21 3:30 PM Exp $$
 */
public class ResverLink {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

    }
    public static void main(String[] args) {
        ResverLink solution = new ResverLink();
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode listNode1 = solution.reverseList(listNode);
    }

    public static class ListNode {
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
}
