package typicalAlgorithom.DP.EditString;

//求最长公共子序列的长度
public class TheLongest {
    public int solution(String str, String str2){
        int m = str.length();
        int n = str2.length();
        //           str 到 m位置， str2 到 n 位置 对应的最长公共子序列
        int [][] dp = new int[m+1][n+1];

        /**
         * str[i] == str2[j] dp[i][j]  = dp[i-1][j-1] +1
         * else dp[i][j] = Max(dp[i-1][j], dp[i][j-1]
         */

        for(int i = 1; i <= m ;i++){
            for(int j = 1; j <= n ;j ++){
                if(str.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    //将公共子序列打印出
    public String solution1(String str, String str2){
        int m = str.length();
        int n = str2.length();
        //           str 到 m位置， str2 到 n 位置 对应的最长公共子序列
        int [][] dp = new int[m+1][n+1];

        /**
         * str[i] == str2[j] dp[i][j]  = dp[i-1][j-1] +1
         * else dp[i][j] = Max(dp[i-1][j], dp[i][j-1]
         */

        for(int i = 1; i <= m ;i++){
            for(int j = 1; j <= n ;j ++){
                if(str.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        int j = n;
        for(int i = m; i>0 && j > 0; i--){

            if(str.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str.charAt(i-1));
                j--;
                continue;
            }else if(str.charAt(i-1) != str2.charAt(j-1) && dp[i-1][j] == dp[i][j-1]){
                j--;
                i++;//恢复，为下次i的循环
            }else if(str.charAt(i-1) != str2.charAt(j-1) && dp[i-1][j] != dp[i][j-1]){
                if(dp[i-1][j] > dp[i][j-1]){
                    continue;
                }else {
                    j--;
                    i++;//恢复，为下次i的循环
                }
            }

        }

        return sb.reverse().toString();
    }
}
