package typicalAlgorithom.String;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC409 {

    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }

        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt / 2) * 2;//只取偶数部分，比如有该字符出现了3次，那我们只用2次就可以
        }

        if (palindrome < s.length()) {
            palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
        }
        return palindrome;
    }

    public int longestPalindrome2(String s) {
        int odd = 0;
        int even = 0;
        int [] num = new int[58];
        for(int i =0; i< s.length(); i++){
            char cur = s.charAt(i);
            num [cur - 'A'] += 1;
        }

        for(int i = 0; i< 58; i++){
            int time = num[i];
            if(time != 0){
                if(time %2 ==1){
                    odd = Math.max(odd, time);
                }else {
                    even += time;
                }
            }
        }
        return odd + even;
    }
}
