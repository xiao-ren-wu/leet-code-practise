//package org.ywb.practise.difficulty;
//
//import java.util.*;
//
///**
// * @author yuwenbo1
// * @date 2020/11/4 7:48 下午 星期三
// * @since 1.0.0
// * 57. 插入区间
// * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
// * <p>
// * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
// * 示例 1：
// * <p>
// * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
// * 输出：[[1,5],[6,9]]
// * 示例 2：
// * <p>
// * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// * 输出：[[1,2],[3,10],[12,16]]
// * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// * https://leetcode-cn.com/problems/insert-interval/
// */
//public class Insert {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        Stack<int[]> res = new Stack<>();
//        int start = -1, end = -1;
//        for (int i = 0; i < intervals.length; i++) {
//            int[] ints = res.peek();
//            if (ints != null) {
//                start = ints[0];
//                end = ints[1];
//            }
//            int[] interval = intervals[i];
//
//        }
//    }å
//}
//
//
//
//
//
//
//
//
//
//
//
//
