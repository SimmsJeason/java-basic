package typicalAlgorithom.DP.DivisionInteger;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC91 {

    /**
     * 如果 s[i] == '0' ，字符 s[i] 就不能单独解码，所以当 s[i] != '0' 时，dp[i] = dp[i - 1] * 1。
     * 说明：为了得到长度为 i + 1 的前缀子串的解码个数，需要先得到长度为 i 的解码个数，再对 s[i] 单独解码，这里分了两步，
     * 根据「分步计数原理」，用乘法。这里的 1 表示乘法单位，语义上表示 s[i] 只有 1 种编码。
     *
     * 如果当前字符和它前一个字符，能够解码，即 10 <= int(s[i - 1..i]) <= 26，即 dp[i] += dp[i - 2] * 1；
     * 说明：不同的解码方法，使用「加法」，理论依据是「分类计数的加法原理」，所以这里用 +=。
     *
     * 注意：状态转移方程里出现了下标 i - 2，需要单独处理（如何单独处理，需要耐心调试）。
     *
     * 第 3 步：初始化
     *
     * 如果首字符为 0 ，一定解码不了，可以直接返回 0，非零情况下，dp[0] = 1；
     * 第 4 步：考虑输出
     *
     * 输出是 dp[len - 1]，符合原始问题。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-java-python-by-liweiwei1419/
     */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            int num = Integer.valueOf(s.substring(i-1,i+1));
            if(num >=10 && num <=26){
                if(i == 1){
                    dp[i] ++;
                }else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n-1];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        int [] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            int shi = s.charAt(i-1) - '0';
            int num = shi*10 + s.charAt(i) -'0';
            if(num >=0 && num < 27){
                if((i+1)%2==0){
                    dp[i] = dp[i-1] +1;
                }else {
                    dp[i] = dp[i-1] +2;
                }
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
