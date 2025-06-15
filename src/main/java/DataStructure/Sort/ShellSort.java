package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        shell2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基于交换的希尔排序
    public static void shell1(int [] arr){

        //k 表示步长，每次循环少一半
        for(int k = arr.length/2; k > 0; k /= 2){

            for (int i = k; i < arr.length; i++){
                for(int j = i - k; j >= 0; j -= k){
                    if(arr[j] > arr[j + k]){
                        int tmp = arr[j];
                        arr[j] = arr[j + k];
                        arr[j + k] = tmp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //基于移位的希尔排序
    public static void shell2(int [] arr){

        //k 表示步长，每次循环少一半
        for(int gap = arr.length/2; gap > 0; gap /= 2){

            //以下是插入排序
            for (int i = gap; i < arr.length; i++){
               int j = i;
               int tmp = arr[j];

               while(j - gap >= 0 && tmp <arr[j-gap]){
                   //移动
                   arr[j] = arr[j-gap];
                   j -= gap;
               }
               //while循环结束后，找到tmp的插入位置
               arr[j] = tmp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
