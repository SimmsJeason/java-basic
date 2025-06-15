package typicalAlgorithom.DP.Package01;

import java.util.HashSet;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
public class LC139 {
    //dp[i] 字符串 ss 前 ii 个字符组成的字符串 s[0..i-1]s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
    // 从前往后计算考虑转移方程，每次转移的时候我们需要枚举包含位置 i-1i−1 的最后一个单词，
    // 看它是否出现在字典中以及除去这部分的字符串是否合法即可
    //dp[i]=dp[j] && check(s[j..i−1])


    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordList = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && wordList.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
