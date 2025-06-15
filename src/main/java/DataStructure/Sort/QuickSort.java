package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        quick(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }

    //填坑法
    public static void quick(int [] array, int left, int right){

        if(left<right){
            int l = left;//左下标
            int r = right;//右下标
            int pivot = array[l];//中轴值设为 区间 第一个数

            while(l<r){
                //在右边一直找，找到小于中轴值的数
                while(l<r && array[r] >= pivot){
                    r--;
                }

                //找到了
                if(l<r){
                    array[l] = array[r];
                    l++;
                }

                //在左边一直找，找到大于中轴值的数
                while (l<r && array[l] <= pivot){
                    l++;
                }

                //找到了
                if(l<r){
                    array[r] = array[l];
                    r--;
                }

            }
            //退出时， l = r，此时即为该值应该在数组上的位置
            array[l] = pivot;
            quick(array, left, l-1);//左递归
            quick(array, l + 1, right);//右递归
        }
    }

    public static void quick1(int [] array, int left, int right){

        int l = left;//左下标
        int r = right;//右下标

        int pivot = array[(left + right)/2];//中轴值
        int temp = 0;

        while(l<r){

            //在左边一直找，找到大于中轴值的位置
            while (array[l] > pivot){
                l++;
            }

            //在右边一直找找到小于中轴值的位置
            while(array[r] < pivot){
                r--;
            }

            //说明结束了
            if(l >= r){
                break;
            }
            //交换
            temp = array[r];
            array[r] = array[l];
            array[l] = temp;

        }
        //如果交换完后，发现arr[l] == pivot ,r-- 前移
        if(array[l] == pivot) r--;

        //如果交换完后，发现arr[r] == pivot ,l++ 后移
        if(array[r] == pivot) l++;

        //如果 l== r, 必须 l++, r--

        //向左递归
        if(left < r)  quick1(array, left, r);

        //向右递归
        if(right > l)  quick1(array, l, right);
    }


}
