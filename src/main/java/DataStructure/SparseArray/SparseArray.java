package SparseArray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个棋盘（原始的二维数组11*11）
        //0：表示没有棋子，1：表示黑色棋子，2：表示蓝色棋子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr) {//对二维数组中的整行遍历
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转稀疏数组的思想
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //创建对应的稀疏数组
        int[][] sparsArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparsArr[0][0] = chessArr.length;
        sparsArr[0][1] = chessArr[0].length;
        sparsArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 1;//计数器，用于记录是第几个非零数据
        for(int i = 0; i<chessArr.length; i++){
            for (int j =0; j<chessArr[0].length;j++){
                if (chessArr[i][j]!=0){
                    sparsArr[count][0] = i;
                    sparsArr[count][1] = j;
                    sparsArr[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组");
        for (int[]row:sparsArr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("还原的二维数组");
        //将稀疏数组恢复成原始的二维数组
        //1.根据sparsArr第一行创建二维数组
        int[][] chessArr2 = new int[sparsArr[0][0]][sparsArr[0][1]];
        //2.再读取稀疏数组的后几行的数据（从第二行开始），并赋值给新的二维数组即可
        for (int i = 1; i<=sparsArr[0][2];i++){
            chessArr2[sparsArr[i][0]][sparsArr[i][1]] = sparsArr[i][2];
        }

        for (int[] row:chessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
