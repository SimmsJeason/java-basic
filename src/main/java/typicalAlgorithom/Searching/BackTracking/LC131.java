package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC131 {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();

        if(len == 0) return  res;

        backTracking(res, new ArrayList<String>(), s);
        return res;
    }

    public void backTracking(List<List<String>> res , List<String> one, String s){
        if(s.length() == 0){
            res.add(new ArrayList<>(one));
            return;
        }

        for(int i = 0 ; i < s.length(); i++){
            String str = s.substring(0,i+1);
            if(isNum(str)){
                one.add(str);
                backTracking(res, one, s.substring(i+1));
                one.remove(one.size() -1);
            }
        }
    }

    public boolean isNum(String s ){
        int l = 0;
        int r = s.length()-1;

        while(l<= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
