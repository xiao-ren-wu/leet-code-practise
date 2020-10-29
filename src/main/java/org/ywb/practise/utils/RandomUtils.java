package org.ywb.practise.utils;

import java.util.Random;

/**
 * @author yuwenbo1
 * @date 2020/10/20 7:50 下午 星期二
 * @since 1.0.0
 */
public class RandomUtils {

    /**
     * 随机数种子
     */
    private static final Random RAND = new Random();

    /**
     * 生成随机整数数
     *
     * @param bound       整数范围
     * @param containZero 是否包含0
     * @return randomInt
     */
    public static int randomInt(int bound, boolean containZero) {
        int num = RAND.nextInt(bound);
        if (containZero) {
            return num;
        }
        while (num == 0) {
            num = randomInt(bound, false);
        }
        return num;
    }

    /**
     * 生成随机数，不包含0
     *
     * @param bound 随机数范围
     * @return randomInt
     */
    public static int randomInt(int bound) {
        return randomInt(bound, false);
    }

    /**
     * 生成随机数low-height之间
     *
     * @param low    low
     * @param height height
     * @return [low, height)
     */
    public static int randomInt(int low, int height) {
        int bound = height - low;
        return randomInt(bound, true) + low;
    }
}
