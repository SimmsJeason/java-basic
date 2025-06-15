package DataStructure.Algorithom.DivideAndConquer;

public class Hanoitower {
    public static void main(String[] args) {

        Hanoitower(2, 'A', 'B', 'C');
    }

    public static void Hanoitower(int num, char a, char b, char c){
        if(num == 1){
            System.out.println("第1个盘从 " + a + " -> " + c);
        }else {

            //当n >= 2 时，我们仍可以视作是两个盘 （1）除最下面的盘之外的盘视为一个盘,记为盘1 （2） 最下面的盘视为第二个盘，记为盘2
            //1. 先把最上面所有的盘移动到B 上，A -> B 中间需要 C 辅助
            Hanoitower(num-1, a, c, b);
            //2. 把最下面的盘 A -> C
            System.out.println("第" + num + "个盘从" + a + " -> " + c);
            //3. 把B塔上的盘 B -> C ，中间需要 A
            Hanoitower(num-1, b, a, c);
        }
    }
}
