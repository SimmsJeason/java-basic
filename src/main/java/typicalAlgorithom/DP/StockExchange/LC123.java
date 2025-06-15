package typicalAlgorithom.DP.StockExchange;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC123 {

    public static void main(String[] args) {
        LC123 lc123 = new LC123();
        int [] prices = {1,2};
        System.out.println(lc123.maxProfit(prices));
    }

    /**
     *1. 定义状态：dp一维日期，二维持有状态，0，不持有股票，持有现金，1持有股票,三维卖出次数：0 ，1，2
     *     dp[i][j][k] 表示：在下标为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。
     * 2. DP方程：
     *   - 2.1不持股票，来源：
     *         1. dp[i][0][0] 未卖出过：dp[i-1][0][0]
     *         2. 之前已卖出一次，昨天未持有股票dp[i-1][0][1],或昨天持有股票，今天第一次将持有股票卖出dp[i-1][1][0]+prices[i];
     *             dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][1][0]+prices[i]);
     *         3. 之前已卖出二次，昨天未持有股票dp[i-1][0][2],或昨天持有股票，已卖出过一次，今天第二次将持有股票卖出dp[i-1][1][1]+prices[i];
     *             dp[i][0][2] = Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i]);
     *   - 2.2 持有股票,来源：
     *         1.  未卖出：之前已买入,昨天持有股票dp[i-1][1][0]，或昨天未持有，今天买入dp[i-1][0][0]-prices[i]
     *             dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
     *         2.  卖出1次：昨天持有股票，但之前已卖出一次，dp[i-1][1][1],或昨天未持有，之前已卖出一次，今天再次买入dp[i-1][0][1]-prices[i]
     *             dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
     *         3. 卖出二次 昨天持有股票但之前已卖出二次，dp[i-1][1][2], 但根据题意最多交易两次，因此这种情况不存在
     * 3. 初始状态：
     *     假设：
     *         第一持有，不管卖出次数是否存在，值都为：dp[0][1][?]=-prices[0];
     *         第一天不持有,不管卖出次数是否存在，值都为： dp[0][0][?]=0;
     * 4. 结果输出：
     *     获取最大收益,一定是用户手上不在持有股票，可能交易过一次，也可能交易过两次
     *     Math.max(dp[len-1][0][2],dp[len-1][0][1]);
     *
     * 作者：echoes-a
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-zui-jia-shi-ji-iiidong-tai-gui-hua/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int len =  prices.length;
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];
        for(int i=1;i<len;++i){
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][1][0]+prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2],dp[i-1][1][1]+prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][0][0]-prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][1]-prices[i]);
            dp[i][1][2] = 0;
        }
        return Math.max(dp[len-1][0][2],dp[len-1][0][1]);
    }


    /**
     *注意：这次是以 [交易结束时刻] 为考虑，之前是以  [天数的结束时刻] 为考虑
     *
     *
     * dp[i][2][2] :
     * dp[i][0][0] 第一次持有股票的最大收益
     * dp[i][0][1] 第一次交易结束，不持有股票的最大收益
     * dp[i][1][0] 第二次持有股票的最大收益
     * dp[i][0][1] 第二次交易结束，不持有股票的最大收益
     *
     *
     *dp[0][0][0] = -prices[i]
     * dp[0][1][0] = Integer.MIN，这个值不存在
     *
     *dp[i][0][0] 的状态是 1.当天买入 =-prices[i],2. 之前卖了还未卖出 ： dp[i-1][0][0] 第一次买入，是负收益
     *
     * dp[i][0][1]  1.今天卖出 dp[i][0][0] + prices[i]  2. 前一天的状态  dp[i-1][0][1] 取最大值
     *
     *dp[i][1][0] = 1. dp[i][0][1] - prices[i] 第二次买入  2.前一天的状态，即些天买了没买出
     *
     * dp[i][1][0] 1.今天卖出dp[i][1][0] + prices[i]  2. 前一天状态 dp[i-1][1][1] 取最大值
     *
     */

    public int maxProfit1(int[] prices) {

        if(prices == null || prices.length == 0) return  0;
        int n = prices.length;
        //       n -> 天数  2 —> 1，2次交易， 2 -> 1表示买入， 0 表示卖出
        int [][][] dp = new int[n][2][2];
        dp[0][0][0] = - prices[0];
        dp[0][1][0] = Integer.MIN_VALUE;
        for(int i = 1; i< n; i++){
            dp[i][0][0] = Math.max(dp[i-1][0][0], -prices[i]);
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i][0][0] + prices[i] );
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i][0][1] - prices[i] );
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i][1][0] + prices[i] );
        }

        return dp[n-1][1][1];
    }
}
