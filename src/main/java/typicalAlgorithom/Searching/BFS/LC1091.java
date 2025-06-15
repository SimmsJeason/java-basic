package typicalAlgorithom.Searching.BFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC1091 {
    public int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        //注意方向数组的顺序，向下探寻的一组在前边，    左右探寻的在中间，    往回探寻的在最后
        //这样能保证第一个返回的是最小值
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();//很关键
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public int shortestPathBinaryMatrix2(int[][] grid) {

        if(grid == null || grid.length ==0 || grid[0].length == 0) return -1;

        int ans = 1000;
        int m = grid.length;
        int n = grid[0].length ;

        int [] [] directions= {{1,1},{0, 1},{1,0},{1,-1},{0, -1},{-1,-1},{-1,0},{-1,1}};

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> start = new Pair<>(0,0);
        queue.add(start);

        int res = 0;
        while(!queue.isEmpty()){

            Pair<Integer, Integer> cur = queue.poll();

            int i = cur.getKey();
            int j = cur.getValue();

            if(grid[i][j] == 1) continue;

            if(i == m-1 && j == n-1) {
                res ++;
                ans = Math.min(ans, res);
                res = 0; //清除
            }else {
                grid[i][j] = 1;
                res ++;
            }

            //广度优先入队
            for(int [] direction : directions){
               int i1 = direction[0] + i;
               int j1 = direction[1] + j;

               if(i1>=0 && i1 < m && j1 >=0 && j1<n){
                   Pair<Integer, Integer> node = new Pair<>(i1, j1);
                   queue.add(node);
               }
            }

        }

        if(ans == 1000) ans = -1;

        return ans;
    }


}
