package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RadixSort {
    public static void main(String[] args) {
        double[] arr = {8,9,1,7,2,3,5,4,6,0};

        double[] result = radixSort(arr, 5);
        System.out.println(Arrays.toString(result));
    }

    public static void radixSort1(int [] array){
        //定义10个桶，为了防止溢出，用空间换时间
        int[][] bucket = new int[10][array.length];

        //用来记录每个桶中元素的个数
        int[] bucketElementCounts = new int[10];

        for(int j = 0; j < array.length; j++){
            //取出每个元素的个位的值
            int digitOfElement = array[j]%10;
            //放入对应的桶中,bucketElementCounts[digitOfElement] 取出对应桶中已经放了多少个数了
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
            bucketElementCounts[digitOfElement] ++;

            //按照桶的顺序将元素取出放入array中去
            int index = 0;
            for(int k = 0; k < bucket.length; k++){
                if(bucketElementCounts[k] !=0){
                    for(int l = 0; l < bucketElementCounts[k]; l++){
                        array[index] = bucket[k][l];
                        index++;
                    }
                }
            }
        }
    }

    public static double[] radixSort(double arr[], int bucketCount) {

        int len = arr.length;
        double[] result = new double[len];
        double min = arr[0];
        double max = arr[0];
        //找到最大值和最小值
        for (int i = 1; i < len; i++) {
            min = min <= arr[i] ? min: arr[i];
            max = max >= arr[i] ? max: arr[i];
        }
        //求出每一个桶的数值范围
        double space = (max - min + 1) / bucketCount;
        //先创建好每一个桶的空间,这里使用了泛型数组，第一维是数组，第二维是链表
        ArrayList< Double >[] arrList = new ArrayList[bucketCount];
        //把arr中的数均匀的的分布到[0,1)上，每个桶是一个list，存放落在此桶上的元素
        for (int i = 0; i < len; i++) {
            //Math.floor() 是向下取整
            int index = (int) Math.floor((arr[i] - min) / space);
            if (arrList[index] == null) {
                //如果链表里没有东西
                arrList[index] = new ArrayList < Double > ();
                arrList[index].add(arr[i]);
            } else {
                //排序，使用的是插入排序
                int k = arrList[index].size() - 1;
                while (k >= 0 && (Double) arrList[index].get(k) > arr[i]) {
                    if (k + 1 > arrList[index].size() - 1) {
                        arrList[index].add(arrList[index].get(k));
                    } else {
                        arrList[index].set(k + 1, arrList[index].get(k));
                    }
                    k--;
                }
                if (k + 1 > arrList[index].size() - 1) {
                    arrList[index].add(arr[i]);
                } else {
                    arrList[index].set(k + 1, arr[i]);
                }
            }

        }

        //把各个桶的排序结果合并  ,count是当前的数组下标
        int count = 0;

        for (int i = 0; i < bucketCount; i++) {
            if (null != arrList[i] && arrList[i].size() > 0) {
                Iterator< Double > iter = arrList[i].iterator();
                while (iter.hasNext()) {
                    Double d = (Double) iter.next();
                    result[count] = d;
                    count++;
                }
            }
        }
        return result;
    }

}
