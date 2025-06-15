package typicalAlgorithom.DoublePointer;

public class LC345 {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 示例 1:
     *
     * 输入: "hello"
     * 输出: "holle"
     * 示例 2:
     *
     * 输入: "leetcode"
     * 输出: "leotcede"
     * 说明:
     * 元音字母不包含字母"y"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;

        while(i<j){
          while (!isVowel(chars[i]) && i<j){
              i++;
          }

          while (!isVowel(chars[j]) && j>i){
              j--;
          }

          if(i<j){
              char tmp = chars[i];
              chars[i] = chars[j];
              chars[j] = tmp;
              i++;
              j--;
          }
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }else{
            return false;
        }
    }
}
