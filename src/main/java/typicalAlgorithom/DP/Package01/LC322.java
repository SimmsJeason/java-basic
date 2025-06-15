package typicalAlgorithom.DP.Package01;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC322 {

    /**
     * 带备忘录的，自上向下的递归
     */
    public static void main(String[] args) {
        LC322 lc322 = new LC322();
        int [] coins = {2};
        System.out.println(lc322.coinChange0(coins, 3, new int[4]));
    }

    //                                              memo 备忘录
    public int coinChange0(int[] coins, int amount, int [] memo) {

        if(amount < 0){
            return -1;
        }

        if(amount == 0){
            return 0;
        }

        if(memo[amount] != 0) return memo[amount];

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < coins.length; i++){
            int subProblem = coinChange0(coins, amount - coins[i], memo);
            if(subProblem == -1)continue;
            min = Math.min(min,  1 + subProblem);
        }

        //记录备忘录
        memo [amount] = (min == Integer.MAX_VALUE) ? -1: min;

        return memo[amount];
    }



    /**
     *常规dp 状态转移
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //将逆序遍历改为正序遍历
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;

                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int len = coins.length;

        int [] dp = new int[amount +1];
        dp[0] = 0;

        //状态方程  dp[i] = Min( dp[i - coins[j]] ) + 1;

        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] < min){
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


}
