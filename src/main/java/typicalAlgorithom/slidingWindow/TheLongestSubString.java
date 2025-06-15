package typicalAlgorithom.slidingWindow;

/**
 * 求一串字符中的最长连续子串的长度
 * aaabbbcccdddeeee
 *
 * 结果为 4 -> eeee
 */
public class TheLongestSubString {
    public static void main(String[] args) {
        TheLongestSubString tt = new TheLongestSubString();
        System.out.println(tt.solution("aaabbbccceeeegsfsgsfgyyyyyyygsdgsdgshsyrrrrrr"));
    }
    public int solution(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int n = str.length();
        int [] dp = new int [n];
        //dp[i] 求到目前为止最长的连续字串长度
        //count 当前的连续字串的长度
        //dp[i] = max(count, dp[i-1])
        //str[i] == str[i-1] count ++;
        //str[i] != str[i-1] count = 1;

        dp[0] = 1;
        int count = 1;
        for(int i = 1; i< n; i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else {
                count = 1;
            }

            dp[i] = Math.max(dp[i-1], count);

        }

        return dp[n-1];
    }
    class Solution {
        private int[] map = new int[26];

        public int characterReplacement(String s, int k) {
            if (s == null) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int left = 0;
            int right = 0;
            int historyCharMax = 0;
            for (right = 0; right < chars.length; right++) {
                int index = chars[right] - 'A';
                map[index]++;
                historyCharMax = Math.max(historyCharMax, map[index]);
                if (right - left + 1 > historyCharMax + k) {
                    map[chars[left] - 'A']--;
                    left++;
                }
            }
            return chars.length - left;
        }
    }

}
