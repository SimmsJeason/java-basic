package typicalAlgorithom.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC205 {

    //记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。

    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            preIndexOfS[sc] = i + 1;//因为数组默认是0，所以记录下标从 1 开始记录
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char curS = s.charAt(i);
            char curT = t.charAt(i);

            if(map1.get(curS) != null){
                if(map1.get(curS) != curT){
                    return false;
                }else {
                    continue;
                }

            }else {
                map1.put(curS, curT);
            }

            if(map2.get(curT) != null){
                if(map2.get(curT) != curS){
                    return false;
                }else {
                    continue;
                }

            }else {
                map2.put(curT, curS);
            }
        }

        return true;
    }
}
