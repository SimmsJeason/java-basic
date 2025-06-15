package typicalAlgorithom.DP.StockExchange;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 *
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class lc188 {

    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0||k == 0) return 0;
        int n = prices.length;

        if(k > n/2) {
            //普通的股票问题
            int [][] dp = new int[n][2];//第几天； 是否持有股票
            dp[0][0] = -prices[0];
            //dp[i][0] 状态有： 1.今天卖出 dp[i][0] + prices[i] 2.上一个为持有股票状态 dp[i-1][1]， 取最大值
            // dp[i][1] 状态有： 1.今天卖出 dp[i-1][1] - prices[i] 几天买入持有，负收益 2.上一个为持有股票状态 dp[i-1][0] ，取最大值

            for(int i = 1; i < n; i++){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
                dp[i][1] = Math.max(dp[i][0] + prices[i], dp[i-1][1]);
            }
            return dp[n-1][1];

        }else {
            // 天数， 交易次数， 买卖情况
            int [][][] dp = new int[n][k][2];
            dp[0][0][0] = - prices[0];

            //由买卖两次推广而来

            //第一天 只会买入一次
            for(int i = 1; i< k ; i++){
                dp[0][i][0] = Integer.MIN_VALUE;
            }

            for(int i = 1; i< n; i++){
                //第一次交易的情况
                dp[i][0][0] = Math.max(-prices[i], dp[i-1][0][0]);
                dp[i][0][1] = Math.max(dp[i][0][0] + prices[i], dp[i-1][0][1]);

                // 第 i 次交易 i > 1 时的情况，具体状态转移参照 LC123题解
                for(int j = 1; j < k; j++){
                    dp[i][j][0] =  Math.max(dp[i-1][j][0], dp[i][j-1][1] - prices[i]);
                    dp[i][j][1] = Math.max(dp[i][j][0] + prices[i], dp[i-1][j][1]);
                }
            }
            return dp[n-1][k-1][1];
        }

    }
}
