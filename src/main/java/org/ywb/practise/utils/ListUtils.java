package org.ywb.practise.utils;

import org.ywb.practise.list.ListNode;

/**
 * @author yuwenbo1
 * @date 2020/10/20 10:06 下午 星期二
 * @since 1.0.0
 */
public class ListUtils {
    /**
     * 创建链表
     *
     * @param listLen 链接节点数量
     * @param border  值范围
     * @return 链表头结点
     */
    public static ListNode createLinkList(int listLen, int border) {
        ListNode head = null, tail = null;
        for (int i = 0; i < listLen; i++) {
            if (null == head) {
                head = new ListNode(RandomUtils.randomInt(border));
                tail = head;
            } else {
                tail.next = new ListNode(RandomUtils.randomInt(border));
                tail = tail.next;
            }
        }
        return head;
    }

    /**
     * 通过给定的数组创建链表
     *
     * @param valArr valArr[]
     * @return list header
     */
    public static ListNode createLinkList(int[] valArr) {
        if (valArr == null || valArr.length == 0) {
            return null;
        }
        ListNode head = null, tail = null;
        for (int val : valArr) {
            if (null == head) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
        }
        return head;
    }

    /**
     * 打印链表
     *
     * @param head list header
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("^");
    }

    /**
     * 翻转链表
     *
     * @param head listHead
     * @return head
     */
    public static ListNode flip(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hn = null, p = head;
        while (head != null) {
            head = head.next;
            p.next = hn;
            hn = p;
            p = head;
        }
        return hn;
    }
}
