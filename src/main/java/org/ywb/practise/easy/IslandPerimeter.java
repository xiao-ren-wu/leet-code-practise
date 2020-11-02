package org.ywb.practise.easy;

import com.sun.javafx.sg.prism.NGArc;


/**
 * @author yuwenbo1
 * @date 2020/10/30 8:00 上午 星期五
 * @since 1.0.0
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int cnt = 4;
                if (i == 0) {
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        cnt--;
                    }
                } else if (i == grid.length - 1 ) {
                    if (grid[i - 1][j] == 1) {
                        cnt--;
                    }
                } else {
                    if (grid[i - 1][j] == 1) {
                        cnt--;
                    }
                    if (grid[i + 1][j] == 1) {
                        cnt--;
                    }
                }
                if (j == 0) {
                    if (j+1<grid[i].length&&grid[i][j + 1] == 1) {
                        cnt--;
                    }
                } else if (j == grid[i].length - 1) {
                    if (grid[i][j - 1] == 1) {
                        cnt--;
                    }
                } else {
                    if (grid[i][j + 1] == 1) {
                        cnt--;
                    }
                    if (grid[i][j - 1] == 1) {
                        cnt--;
                    }
                }
                sum += cnt;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]{{1}}));
//        System.out.println("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]".replaceAll("\\[", "{")
//                        .replaceAll("]", "}"));

    }
}


















