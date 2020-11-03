package org.ywb.practise.easy;

/**
 * @author yuwenbo1
 * @date 2020/11/3 11:26 上午 星期二
 * @since 1.0.0
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length <= 2) {
            return false;
        }
        int i = 1;
        while (i < A.length && A[i] > A[i - 1]) {
            i++;
        }
        if (i == 1 || i == A.length) {
            return false;
        }
        while (i<A.length&&A[i]<A[i-1]){
            i++;
        }
        return i==A.length;
    }
}
