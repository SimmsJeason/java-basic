package typicalAlgorithom.Other;

/**
 *     ***[ 差分数组 ]***
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *  
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *  
 *
 * 提示：
 *
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference difference = new Difference(new int[n]);

        for(int [] cur : bookings){
            difference.increment(cur[0]-1, cur[1]-1, cur[2]);
        }
        int [] res = difference.result();
        return res;
    }
}

class Difference{

    private int [] diff;

    public Difference(int [] nums){
        diff = new int[nums.length];
        diff[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int i , int j , int val){
        diff[i] += val;
        if(j +1 < diff.length){
            diff[j+1] -= val;
        }
    }

    public int[] result(){
        int [] res = new int[diff.length];
        res[0] = diff[0];

        for(int i = 1; i < diff.length ; i++){
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }
}