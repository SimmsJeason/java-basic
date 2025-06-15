package typicalAlgorithom.DP.Package01;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 *
 * 注意:
 *
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * 示例 1:
 *
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 *
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * 示例 2:
 *
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 *
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC474 {

    /**
     *定义 dp 数组，dp[i][j][k] : 选择前 i 个字符串，在 0 的个数为 j, 1 的个数为 k 的条件下可以获得的最大字符串个数
     * 状态转移：dp[i][j][k] = max(dp[i-1][j][k], dp[i-1][j - curr(0))][k - curr(1))] + 1)
     * 选择与不选择当前字符串的最大值, 选择的话，0 背包的容量变成了 j - 当前字符串中 0 的个数, 1 背包的容量为 k - 当前字符串中 1 的个数
     * base case ：dp[0][j][k] = 0
     *
     */

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {    // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0 ) return 0;
        int [][][]dp = new int[strs.length+1 ][m+1][n+1];

        for(int i = 1; i<= strs.length; i++){
            int cur0 = count(strs[i-1], "0");
            int cur1 = count(strs[i-1], "1");
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n ;k ++){
                    if(j - cur0 >= 0 && k - cur1 >= 0){

                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-cur0][k-cur1]+1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }

                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int count(String s, String s1){
        String tmp = s;
        return s.length() - tmp.replaceAll(s1,"").length();
    }
}
