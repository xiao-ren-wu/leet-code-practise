package org.ywb.practise.list;


/**
 * @author yuwenbo1
 * @date 2020/10/20 7:48 下午 星期二
 * @since 1.0.0
 * 单向链表
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
