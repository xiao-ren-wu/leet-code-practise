package org.ywb.practise.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuwenbo1
 * @date 2020/10/22 8:17 上午 星期四
 * @since 1.0.0
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        if (S == null || "".equals(S)) {
            return null;
        }
        char[] chars = S.toCharArray();
        // 存储每个字符最后出现的位置
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            pos.put(chars[i], i);
        }
        List<Integer> pl = new ArrayList<>();
        int begin = 0;
        while (begin < chars.length) {
            int curMax = pos.get(chars[begin]);
            for (int j = begin; j < curMax; j++) {
                Integer curIndex = pos.get(chars[j]);
                if (curIndex > curMax) {
                    curMax = curIndex;
                }
            }
            pl.add(curMax - begin + 1);
            begin = curMax + 1;
        }
        return pl;
    }

}















