package org.ywb.practise.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuwenbo1
 * @date 2020/11/2 11:58 上午 星期一
 * @since 1.0.0
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problemsintersection-of-two-arrays/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i : nums1) {
            res.put(i, 0);
        }
        for (int i : nums2) {
            Integer value = res.get(i);
            if (value != null) {
                res.put(i, value + 1);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        res.forEach((k, v) -> {
            if (v >= 1) {
                list.add(k);
            }
        });
        int[] ints = new int[list.size()];
        AtomicInteger i = new AtomicInteger();
        list.forEach(a -> ints[i.getAndIncrement()] = a);
        return ints;
    }

    public static void main(String[] args) {
        int[] intersection = new Intersection().intersection(new int[]{}, new int[]{1, 1});
        for (int i : intersection) {
            System.out.println(i);
        }
    }
}
