package DataStructure.Algorithom.Recursion;

public class Queen8 {
    int max = 8;
    int[] array  = new int[max];//保存皇后存放位置的正确结果
    public static void main(String[] args) {
            Queen8 queen8 = new Queen8();
            queen8.check(0);
    }

    //放置皇后的算法
    private void check (int n){
        if(n == max){
            show();
            return;
        }

        for(int i = 0; i < max; i++){
            //先把当前的皇后n放在第一列
            array[n] = i;
            //判断该皇后的位置是否冲突
            if(judge(n)){
                check(n+1);
            }

            //如果冲突，则将array[n]后移一列测试
        }
    }

    private boolean judge(int n){
        for(int i = 0; i<n; i++){
            //同一列，或者同一斜线上
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void show(){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
