package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //(3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 -
/*        String suffixExpression = "3 4 + 5 × 6 -";
        List<String> tmp = getListString(suffixExpression);
        int result = calculate(tmp);
        System.out.println("计算结果为： " + result);*/

        //后缀表达式   1, 2, 3, +, 4, *, +, 5, -
        String expression = "1+((2+3)*4)-5";
        List<String> ls = toInfixExpressionList(expression);
        //System.out.println(ls.toString());
        //后缀表达式对应的list
        List<String> ls2 = parseSuffixExpressionList(ls);
        System.out.println(calculate(ls2));
    }

    public static List<String> getListString(String suffixExpression){
        String [] split = suffixExpression.split(" ");
        List<String> strings = new ArrayList<String>();
        for(String ele: split){
            strings.add(ele);
        }
        return strings;
    }

    public static int calculate(List<String> strings){

        Stack<String> stack = new Stack<String>();
        for (String ele: strings){
            if(ele.matches("\\d+")){//正则表达式，数字

                //入栈
                stack.push(ele);
            }else {//计算
                int result = 0;
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                if(ele.equals("+")){
                    result = num1 + num2;
                }else if(ele.equals("-")){
                    result = num1 - num2;
                }else if(ele.equals("*")){
                    result = num1 * num2;
                }else if(ele.equals("/")){
                    result = num1 / num2;
                }else {
                    throw  new RuntimeException("无效操作符！");
                }

                //result 入栈
                stack.push("" + result);
            }
        }
        //最后栈中是数字即为最终结果
        return Integer.parseInt(stack.pop());
    }

    //将中缀表达式转成对应的list
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0 ;//扫描string 用的下标
        String number; //对多位数的拼接
        char c;//每遍历到一个字符，暂存到 c
        do{
            //字符不是数字字符
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i++;
            }else {
                number = "";
                //拼接多位数
                while(i<s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    number += c;
                    i++;
                }
                ls.add(number);
            }
        }while (i<s.length());
        return ls;
    }

        //将中缀表达式的list转换成后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //初始化符号栈
        Stack<String> s1 = new Stack<String>();
        //结果 List
        List<String> s2 = new ArrayList<String>();

        for(String item: ls){
            //如果是数字，直接入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将小括号弹出
            }else {
                //遇到运算符时，比较其与s1栈顶运算符的优先级
                //若优先级不高于栈内运算符，则将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //将item入栈
                s1.push(item);
            }

        }

        while(s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }
}
class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation){
        int result = 0;

        if ("+".equals(operation)) {
            result = ADD;
        } else if ("-".equals(operation)) {
            result = SUB;
        } else if ("*".equals(operation)) {
            result = MUL;
        } else if ("/".equals(operation)) {
            result = DIV;
        } else {
            System.out.println("操作符不合法");
        }
        return result;
    }

}
