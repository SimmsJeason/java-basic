package DataStructure.Algorithom.Dynamic;

public class Knapsack01 {
    public static void main(String[] args) {
        int [] w = {1, 4, 3};//物品重量
        int [] val = {1500, 2000, 3000};//物品价值
        int m = 4;//背包容量
        int n = val.length; //物品个数
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int [][] v = new int[n+1][m+1];
        //记录物品存放过程
        int [][] path = new int [n+1][m+1];

        for(int i = 0; i< v.length; i ++){
            v[i][0] = 0;
        }

        for(int j = 0; j < v[0].length; j++){
            v[0][j] = 0;
        }

        //i , j 从 1 开始， w[] 和 val[]的值都是从 0 号下标开始的，所以下面设计w[], val[] 都要减1
        for(int i = 1; i < v.length; i++){
            for(int j = 1; j< v[0].length; j++){
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //v[i][j] = Math.max(v[i-1][j], val[i-1] + v[i-1][j-w[i-1]]);
                    //因为要记录物品的存放细节，不能直接使用Math.max方法
                    if(v[i-1][j] < (val[i-1] + v[i-1][j-w[i-1]])){
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        //把当前情况记录到path
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        //查看 v  的情况
        for(int i = 0 ; i < v.length; i++ ){
            for(int j = 0; j < v[0].length; j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //查看存放情况，遍历path
        int i = path.length -1;//行的最大下标
        int j = path[0].length -1;//列的最大下标
        while (i > 0 && j > 0 ){//从path最后遍历
            if(path[i][j] == 1)
            {
                System.out.printf("第%d个商品放入背包", i);
                j -= w[i-1];//背包重量要减去对应的物品重量
            }
            i--;
            System.out.println();
        }
    }
}
