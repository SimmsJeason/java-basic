package typicalAlgorithom.slidingWindow;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC567 {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        LC567 lc567 = new LC567();
        System.out.println(lc567.checkInclusion(s1,s2))  ;
    }

    /**
     * 2个字符串的排列 相等 -> 2个字符串 各个字符 的个数都一一相等。
     * 比如aabc和baca这2个字符串的排列是相等的，都包含2个a、1个b、1个c。
     *
     * 题目求：s2是否包含s1的排列，也就是求证s2中是否存在1个区间，该区间长度为s1.length()(即s1字符串的长度)，且该区间内 各个字符 的个数和s1各个字符 的个数 都一一相等。
     *
     * 既然区间长度是固定的(s1.length())，则将该区间从s2的最左端滑动到最右端即可。
     * 典型的动态滑窗问题。
     * 也就是区间的位置从[0, s1.length() - 1]到[s2.length() - s1.length(), s2.length() - 1]。
     *
     * 作者：gfu
     * 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/2ge-shu-zu-hua-dong-chuang-kou-si-xiang-by-gfu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] ch_count1 = new int[26], ch_count2 = new int[26];
        for (int i = 0; i < len1; ++i) {
            ++ch_count1[s1.charAt(i) - 'a'];
            ++ch_count2[s2.charAt(i) - 'a'];
        }
        for (int i = len1; i < len2; ++i) {
            if (isEqual(ch_count1, ch_count2)) return true;
            --ch_count2[s2.charAt(i - len1) - 'a'];
            ++ch_count2[s2.charAt(i) - 'a'];
        }
        return isEqual(ch_count1, ch_count2);
    }

    private boolean isEqual(int[] ch_count1, int[] ch_count2) {
        for (int i = 0; i < 26; ++i)
            if (ch_count1[i] != ch_count2[i])
                return false;
        return true;
    }

}
