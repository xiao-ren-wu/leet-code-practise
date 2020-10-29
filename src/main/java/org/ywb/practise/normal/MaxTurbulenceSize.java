package org.ywb.practise.normal;

/**
 * @author yuwenbo1
 * @date 2020/10/27 12:11 下午 星期二
 * @since 1.0.0
 * <p>
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
public class MaxTurbulenceSize {
    /**
     * K = 1                => 1
     * K = 2                => 2
     * k > k-1 && K-1< k-2 || k < k-1 && k-1> k-1 => 1+n(k-1)
     * k==k-1               => 1
     * => 2
     *
     * @param A arr
     * @return res
     */
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] memo = new int[A.length];
        memo[0] = 1;
        if(A.length>=2){
            if (A[1] != A[0]) {
                memo[1] = 2;
            } else {
                memo[1] = 1;
            }
        }
        for (int i = 2; i < A.length; i++) {
            if (
                    A[i] > A[i - 1] && A[i - 1] < A[i - 2] ||
                            A[i] < A[i - 1] && A[i - 1] > A[i - 2]
            ) {
                memo[i] = 1 + memo[i - 1];
            } else if (A[i] == A[i - 1]) {
                memo[i] = 1;
            } else {
                memo[i] = 2;
            }
        }
        return max(memo);
    }

    private int max(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data[] must not be null");
        }
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            max = Math.max(max, data[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxTurbulenceSize().maxTurbulenceSize(new int[]{123}));
    }
}



























