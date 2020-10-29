package org.ywb.practise.normal;

/**
 * @author yuwenbo1
 * @date 2020/10/24 11:21 上午 星期六
 * @since 1.0.0
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为T秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * <p>
 * 视频片段clips[i]都用区间进行表示：开始于clips[i][0]并于clips[i][1]结束。我们甚至可以对这些片段自由地再剪辑，
 * 例如片段[0, 7]可以剪切成[0, 1] +[1, 3] + [3, 7]三部分。
 * <p>
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回-1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 * <p>
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 * <p>
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]],
 * T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 * <p>
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 * <p>
 * 提示：
 * <p>
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <=clips[i][1] <= 100
 * 0 <= T <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/video-stitching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 贪心，逐步缩小空间
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int begin = 0, end = T;
        int count = 0;
        while (begin < end) {
            int curBegin = begin;
            int curEnd = end;
            int[][] pre = new int[][]{{0, 0}};
            int[][] post = new int[][]{{0, 0}};
            for (int i = 0; i < clips.length; i++) {
                if (clips[i][0] <= begin) {
                    if (clips[i][1] > curBegin) {
                        pre = new int[][]{{clips[i][0], clips[i][1]}};
                        curBegin = clips[i][1];
                    }
                } else if (clips[i][1] >= end ) {
                    if (clips[i][0] < curEnd) {
                        post = new int[][]{{clips[i][0], clips[i][1]}};
                        curEnd = clips[i][0];
                    }
                }
            }
            // 需要再次确认一下，是否存在包含关系，如,包含[5,6][4,7]
            if (pre[0][0] <= post[0][0]&&pre[0][1]>=post[0][1]||pre[0][1]>=end) {
                curEnd = end;
            }else if(pre[0][0] >= post[0][0]&&pre[0][1]<=post[0][1]||post[0][0]<=begin){
                curBegin = begin;
            }

            if (curBegin == begin && curEnd == end) {
                return -1;
            } else {
                if (curBegin != begin) {
                    begin = curBegin;
                    count++;
                }
                if (curEnd != end) {
                    end = curEnd;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0,0},{9,9},{2,10},{0,3},{0,5},{3,4},{6,10},{1,2},{4,7},{5,6}};
        System.out.println(new VideoStitching().videoStitching(data, 5));

    }

//    public static void main(String[] args) {
//        String str = "[[0,0],[9,9],[2,10],[0,3],[0,5],[3,4],[6,10],[1,2],[4,7],[5,6]]";
//        System.out.println(str.replaceAll("\\[", "{").replaceAll("]", "}"));
//    }
}


























