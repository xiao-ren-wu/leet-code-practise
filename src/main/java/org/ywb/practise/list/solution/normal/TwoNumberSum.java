package org.ywb.practise.list.solution.normal;

import org.ywb.practise.list.ListNode;
import org.ywb.practise.utils.ListUtils;

/**
 * @author yuwenbo1
 * @date 2020/10/29 6:26 下午 星期四
 * @since 1.0.0
 */
public class TwoNumberSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null, tail = null;
        int s = 0, n;
        while (l1 != null || l2 != null) {

            n = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + s;
            s = n / 10;
            n %= 10;
            ListNode p = new ListNode();
            p.val = n;
            if (head == null) {
                head = p;
            } else {
                tail.next = p;
            }
            tail = p;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(s!=0){
            ListNode node = new ListNode();
            node.val = s;
            tail.next=node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtils.createLinkList(new int[]{1, 9, 3});
        ListNode l2 = ListUtils.createLinkList(new int[]{1, 2, 3});
        ListNode add = new TwoNumberSum().addTwoNumbers(l1, l2);
        ListUtils.printList(add);
    }
}








