package typicalAlgorithom.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 第一行一个数 n 表示任务的个数
 * 接下来 n 行 每行三个数 l, r, w,分别代表第 i 个任务的开始时间， 结束时间，以及收益。
 * 例如
 * 3
 * 1 3 5
 * 2 7 3
 * 5 10 1
 *
 * 输出 6
 *
 * [1, 3], [5,10]  6 = 5 + 1
 */
public class ShunFeng02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Task[] tasks = new Task[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            long v = sc.nextLong();
            tasks[i] = new Task(s,e,v);
        }
        Arrays.sort(tasks);
        long[] dp = new long[n];
        /**
         *   dp[i] 表示第 i 个任务之前，最大收益是多少
         *   dp[0] = tasks[0].value, 即第一个任务的收益额
         *
         *   dp[i] 的状态方程为： Max(dp[j]) + cur.value 其中  0 <= j < i
         */
        dp[0] = tasks[0].value;
        for(int i = 0; i < n; i++) {
            Task t = tasks[i];
            long max = t.value;
            for(int j = 0; j < i; j++) {
                if(tasks[j].end <= t.start) {
                    max = Math.max(dp[j]+t.value,max);
                }
            }
            dp[i] = max;
        }
        long max = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}

class Task implements Comparable<Task> {
    long start;
    long end;
    long value;
    public Task(int s,int e,long v){
        start = s;
        end = e;
        value = v;
    }

    @Override
    public int compareTo(Task t) {
        if(start == t.start) return (int)(end - t.end);
        else return (int)(start - t.start);
    }
}
