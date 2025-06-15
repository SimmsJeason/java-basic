package typicalAlgorithom.DP.Package01;


import java.util.ArrayList;
import java.util.List;

public class Test1 {
    protected static int cnt = 0;
    public static void main(String[] args) {
        Test1 test = new Test1();
        int [] nums = {1, -3, 0, 6, 4,5};
        test.work(nums, new ArrayList<>(), 6, 0);
        System.out.println(cnt);
    }

    public void work( int [] nums , ArrayList<Integer> one,  int target, int i){

        if(sum(one) + nums[i] == target){
            cnt++;
        }

    }

    public int sum(List<Integer> array){
        int sum = 0;
        for(Integer integer : array){
            sum += integer;
        }
        return sum;
    }
    public int work1(int [] nums , int target){
        int [] dp = new int[target +1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = target; i >= num ; i--){
                dp[i] = dp[i] + dp[i- num];
            }
        }
        return dp[target];
    }
}
