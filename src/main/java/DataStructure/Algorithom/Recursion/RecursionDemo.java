package DataStructure.Algorithom.Recursion;

public class RecursionDemo {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //上下全部置1
        for(int i = 0 ; i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置1
        for (int i = 0; i< 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        setWay(map, 1,1);
        for(int i = 0; i<8 ; i++){
            for (int j = 0; j<7; j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }

    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 表示路已经找到了
            return true;
        } else {
            if (map[i][j] == 0) { // 0: 可以走还没有走
                // 这里开始递归回溯
                map[i][j] = 2; // 认为该点是可以走通,但是不一定
                if (setWay(map, i + 1, j)) { // 下找
                    return true;
                } else if (setWay(map, i, j + 1)) { // 右
                    return true;
                } else if (setWay(map, i - 1, j)) { // 上
                    return true;
                } else if (setWay(map, i, j - 1)) { // 左
                    return true;
                } else {// 走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map(i)(j)!=0
                //则值 1,2,3
                return false;}
        }}

}
