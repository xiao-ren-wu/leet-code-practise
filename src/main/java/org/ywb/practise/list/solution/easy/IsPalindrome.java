package org.ywb.practise.list.solution.easy;

import org.ywb.practise.list.ListNode;
import org.ywb.practise.utils.ListUtils;

/**
 * @author yuwenbo1
 * @date 2020/10/23 8:25 上午 星期五
 * @since 1.0.0
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 翻转中后部分，然后和前半部分对比
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        // 翻转后半部分
        ListNode hn = null, p = slow.next, q;
        slow.next = null;
        while (p != null) {
            q = p.next;
            p.next = hn;
            hn = p;
            p = q;
        }
        // 比较两个链表是都一致
        while (head != null && hn != null) {
            if (head.val != hn.val) {
                return false;
            }
            head = head.next;
            hn = hn.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode linkList = ListUtils.createLinkList(new int[]{ 2, 2});
        boolean palindrome = new IsPalindrome().isPalindrome(linkList);
        System.out.println(palindrome);
    }

}