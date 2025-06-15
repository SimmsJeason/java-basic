package typicalAlgorithom.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LC22 {
    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        List<String> res = lc22.generateParenthesis(3);
        for(String str : res){
            System.out.println(str + " ");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;

        StringBuffer sb = new StringBuffer();
        backTrack(res, sb, 0, 0, n);
        return res;
    }

    public void backTrack(List<String> res , StringBuffer cur, int open, int close, int max){
        if(cur.length() == max*2){
            res.add(cur.toString());
            return;
        }

        if(open < max){
            cur.append('(');
            backTrack(res, cur, open +1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }

        //close >= open 那么括号就不合法了
        if(close < open){
            cur.append(')');
            backTrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
