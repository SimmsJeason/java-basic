package typicalAlgorithom.Searching.DFS;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friend-circles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC547 {

    int n ;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {//自己的朋友
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);//朋友的朋友
            }
        }
    }

    /*********************************************************************/

    public int findCircleNum2(int[][] M) {
        if(M == null || M[0].length == 0) return 0;

        int ans = 0;
        n = M.length;

        for(int i =0; i< n; i++){
            if(M[i][i] ==1){
                dfs2(M, i, i);
                ans ++;
            }
        }

        return ans;
    }

    public void dfs2(int [][] grid, int r , int c){
        if(r <0 || r >= n || c<0 || c >=n || grid[r][c] == 0) return;

        grid[r][c] = 0;

        for(int j = 0; j < n; j++ ){
            dfs2(grid, r, j);//自己的朋友

            dfs2(grid,j, r);//朋友的朋友
        }
    }
}
