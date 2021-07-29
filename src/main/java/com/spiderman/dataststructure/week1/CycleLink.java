package com.spiderman.dataststructure.week1;

/**
 * 环型链表
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0..0: com.spiderman.dataststructure.week1.ResverLink,v 0.1 1/30/21 3:30 PM Exp $$
 */
public class CycleLink {

    //解法1:定义快慢指针，慢指针从0开始，快指针从1开始，慢指针每次走1步，快指针每次走两步
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow !=  fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public static void main(String[] args) {
        CycleLink solution = new CycleLink();
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode1;
        boolean flag=solution.hasCycle(listNode1);
        System.out.println(flag);
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
