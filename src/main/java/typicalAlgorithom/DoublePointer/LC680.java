package typicalAlgorithom.DoublePointer;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC680 {

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                //两种情况都要考虑
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    //有问题
    public boolean validPalindrome2(String s) {

            if(s == null || s.length() == 0 || s.equals("")){
                return true;
            }
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length -1;
            int skip = 0;
            while(i<=j){
                if(chars[i] == chars[j]){
                    i++;
                    j--;
                }else {
                    if(skip >0){
                        return false;
                    }else {
                        //以下处理有问题，处理顺序不同，可能导致结果不同，下面处理应该是同优先级的
                        if(chars[i + 1] == chars[j]){
                            i++;
                            skip ++;
                        }else if(chars[j - 1] == chars[i]){
                            j--;
                            skip++;
                        }else {
                            return false;
                        }
                    }
                }
            }

            return true;
    }
}
