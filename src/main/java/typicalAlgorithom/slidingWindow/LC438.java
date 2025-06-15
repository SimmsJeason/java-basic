package typicalAlgorithom.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC438 {
    public static void main(String[] args) {

        LC438 lc438 = new LC438();
        String s = "abab";
        String p = "ab";
        List<Integer> res = lc438.findAnagrams(s, p);

        res.forEach(i -> System.out.print( i + " "));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int [] char1 = new int[26];
        int [] char2 = new int[26];
        int len1 = s.length();
        int len2 = p.length();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < len2; i ++){
            ++char1[s.charAt(i) - 'a'];
            ++char2[p.charAt(i) - 'a'];
        }

        for(int i = len2; i < len1; i++){
            if(isEqual(char1, char2)) {
                res.add(i - len2);
            }

            -- char1[s.charAt(i - len2) - 'a'];//左边收缩窗口
            ++ char1[s.charAt(i) - 'a'];//右边放大窗口
        }

        if(isEqual(char1,char2)){
            res.add(len1-len2);
        }

        return res;
    }


  

    private boolean isEqual(int [] char1, int [] char2){
        for(int i = 0 ; i < 26; i++){
            if(char1[i] != char2[i]){
                return false;
            }
        }
        return true;
    }
}
