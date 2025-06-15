package DataStructure.Algorithom.KMP;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int [] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
        System.out.println("匹配位置为： " + index);
    }

    //kmp搜索算法
    public static int kmpSearch(String str1, String str2, int [] next){

        for(int i = 0, j = 0; i < str1.length(); i++){

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(j == str2.length()){//找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取一个字符串(子串)的部分匹配值
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串的长度为1， 部分匹配值就为0
        for(int i = 1, j = 0; i < dest.length(); i++){
            //当dest.charAt(i) != dest.charAt(j) 满足时，我们需要从next[j-1]获取新的j
            //j可以视为前缀的结束位置，或者说是前缀的长度。然后倒着往前对比，前缀越短，越有可能匹配
            //直到我们发现右dest.charAt(i) == dest.charAt(j) 成立才退出
            //kmp算法核心
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j-1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就 +1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;

        }

        return next;
    }
}
