package typicalAlgorithom.Searching.DFS;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC200 {
    private int m;
    private int n;
    private int [][] directions = {{0,-1},{0,1},{-1, 0},{ 1,0}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int ans = 0;
         m = grid.length;
         n = grid[0].length;
        for(int i = 0 ; i< m; i++){
            for(int j = 0; j< n; j++){

                   if(dfs(grid, i, j) > 0) ans ++;

            }
        }
        return ans;
    }

    public int dfs(char [][] grid, int r, int c){
        if(r<0 || r>= m || c<0 || c>=n || grid[r][c] == '0')  return 0;

        grid[r][c] = '0';
        int area = 1;

        for(int [] direction : directions){
            area += dfs(grid, r+ direction[0], c + direction[1]);
        }

        return area;
    }

    /********************************************************************/

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandsNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    islandsNum++;
                }
            }
        }
        return islandsNum;
    }

    private void dfs2(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
