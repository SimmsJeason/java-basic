package typicalAlgorithom.String;

/**
 * 反转字符串中的单词，保持字符串中单词的位置不变
 * 例：
 * "I have an    apple"
 * "I evah na    elppa"
 *
 */
public class WordRever {

    public  String swapWords(String s) {
        if (s == null) {
            return null;
        }
        String ret = "";
        if (!s.endsWith(" ")) {
            s += " ";
        }
        char[] charArr = s.toCharArray();
        int begin = 0;

        int i = 0;
        while (i < charArr.length) {
            while (charArr[i] == ' ' && i < charArr.length) {
                i++;
            }
            begin = i; // 获取单词的第一个字母对应的位置
            while (charArr[i] != ' ') { // 找到单词后第一个空格对应的位置
                i++;
            }
            swapStr(charArr, begin, i - 1);
            ++i;//下一个单词开始位置
        }
        ret = new String(charArr);
        return ret;
    }

    public void swapStr(char [] chars, int start, int end){
        System.out.println("start = "+ start + " end = " + end + " len =" + chars.length);
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start ++;
            end --;
        }
    }
}
