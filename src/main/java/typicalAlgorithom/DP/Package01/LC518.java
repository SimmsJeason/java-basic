package typicalAlgorithom.DP.Package01;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 *  
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *  
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC518 {

    // DP  完全背包

    //分析过程见有道笔记

    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        //
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        int [] dp = new int [amount +1];
        if(coins.length == 0 ){
            if(amount == 0){
                return 1;
            }else {
                return 0;
            }
        }

    /*    for(int i : coins){
            if(i <= amount){
                dp[i] = 1;
            }

        }*/

        for(int i = 1; i <= amount; i++){

            int max = Integer.MIN_VALUE;
            for(int j = 0; j < coins.length; j++ ){
                if(i - coins[j] >= 0 && dp[i - coins[j]] > max){
                    max = dp[i - coins[j]]+1;
                }
            }
            dp[i] = max;
        }
        return dp[amount];
    }


    /*********************  超时  *********************************/
    int cnt = 0;
    //回溯法
    public int change2(int amount, int[] coins) {
        if(coins.length == 0 ){
            if( amount == 0){
                return 1;
            }else {
                return 0;
            }
        }

        backTracking(coins, amount, 0);

        return cnt;
    }

    public void backTracking(int [] coins, int amount, int start){
        if(amount == 0 ){
            cnt ++ ;
            return;
        }

        for(int i = start; i< coins.length; i++){
            if(amount - coins[i] >=0){
                //自身可以重复使用，所以下一层递归从 i 开始
                backTracking(coins, amount - coins[i], i);
            }
        }
    }
}