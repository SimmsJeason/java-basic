package Stack;

public class Calculator {
    public static void main(String[] args) {

    }
}

class Work{
    //预算夫优先级
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }


}