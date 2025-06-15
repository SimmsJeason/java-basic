package typicalAlgorithom.DP.DivisionInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC279 {

    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    //获得平方数列表: 1，4，9，16，25， ...
    //每个平方数之间的差值是一个等差数列： 3=4-1; 5 = 9-4; 7= 16-9; 9 = 25-16
    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    /********************************************/

    public int numSquares2(int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2; i <= n ;i++){
            if(isNum(i)) {
                dp[i] = 1;
                continue;
            }

            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j < i; j++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }

    public boolean isNum (int n){
        int sqr = (int) Math.sqrt(n);
        if(sqr * sqr == n){
            return true;
        }else {
            return false;
        }
    }
}
