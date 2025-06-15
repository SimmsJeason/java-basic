package typicalAlgorithom.DP.Fibonacci;

/**
 * 假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，
 * 母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
 */
public class Cows {
    /**
     *  所有的牛都不会死，所以第n-1年的牛会毫无损失地活到第n年。同时。所有成熟的牛都会生1头新的牛，
     * 那么成熟的牛的数量就是第n-3年的所有牛，到第n年的肯定都是成熟的牛。其间出生的牛肯定都没有成熟。
     */

    public int work (int n){
        int [] dp = new int [n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        for(int i = 3; i< n; i++){
            dp[i] = dp[i-1] + dp[i-3];
        }

        return dp[n-1];
    }


}
