package org.ywb.practise.list.solution.normal;

import org.ywb.practise.list.ListNode;

import static org.ywb.practise.utils.ListUtils.*;

/**
 * @author yuwenbo1
 * @date 2020/10/20 10:05 下午 星期二
 * @since 1.0.0
 * <p>
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 分为三步：
 *
 * 找到链表的中间节点
 * 从中间节点一分为二，形成两个链表，并翻转中间节点的后半部分
 * 从前半部分链表开始，依次从两个链表的头部获取节点，并以尾插的形式构建一个新的链表
 *
 * 作者：user5510E
 * 链接：https://leetcode-cn.com/problems/reorder-list/solution/zhong-pai-lian-biao-by-user5510e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 先通过快慢指针找到链表的中间节点
        ListNode slow = head, fast = slow.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode hn = slow.next;
        slow.next = null;
        hn = flip(hn);
        // 合并两个链表
        merge(head, hn);
    }

    private void merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return;
        }
        if (list2 == null) {
            return;
        }
        ListNode head = list1, tail = head;
        list1 = list1.next;
        while (list1 != null && list2 != null) {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;

            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
    }

}
