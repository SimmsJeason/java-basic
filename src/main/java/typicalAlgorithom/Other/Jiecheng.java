package typicalAlgorithom.Other;

import java.math.BigInteger;

public class Jiecheng {

    //大数阶乘
    public static BigInteger A(int a){
        BigInteger temp=new BigInteger("1");
        BigInteger sum=new BigInteger("1");
        for(int i=1;i<=a;i++){
            sum = sum.multiply(temp);
            temp=temp.add(new BigInteger("1"));
        }
        return sum;
    }

    public static BigInteger C(int a,int b){
        BigInteger temp=new BigInteger("0");
        BigInteger sum=new BigInteger("1");
        for(int i=0; i<b; i++){
            String tem=a+"";//a 转化为 String
            BigInteger temp1=new BigInteger(tem);//a 的大数表示
            BigInteger t2=temp1.subtract(temp);
            BigInteger t1=sum.multiply(t2);
            sum = t1.divide(temp.add(new BigInteger("1")));
            temp=temp.add(new BigInteger("1"));
           // System.out.println("temp = " + temp.toString() + " temp1 = " + temp1.toString() + " t2 = " + t2.toString() + " t1 = " + t1.toString() + " sum = " + sum );
        }
        return sum;
    }

    public static void main(String args[]){
        int a = 100;
        int b = 20;
        BigInteger res1=C(a,b);
        System.out.println(res1);

    }

}
