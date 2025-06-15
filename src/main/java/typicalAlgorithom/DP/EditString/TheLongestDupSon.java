package typicalAlgorithom.DP.EditString;


/**
 * 求最长重复字串的长度
 * 例： abcd
 *  0
 *
 * abcabc
 *
 * 3
 */

public class TheLongestDupSon {
    public static void main(String[] args) {
        String str = "abcabc";
        TheLongestDupSon test = new TheLongestDupSon();
        System.out.println(test.solve(str));
    }

    /**
     *dp[i][j]  表示重复字串的最长长度
     * if ( str[i] == str[j]) dp[i][j] = dp[i-1][j-1] +1;
     * if (str[i] != str[j]) dp[i][j] = 0;
     *
     */

    public int solve(String str){
        int n = str.length();
        int [][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                if(str.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                if(i != j && max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

}
