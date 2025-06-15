package Sort;

import java.util.Arrays;

public class InsetSort {
    public static void main(String[] args) {

        int[] arr = {3, 9, -1, 10, 20, -2};

        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int [] arr){
        for(int i = 1; i< arr.length; i++){
            //待插入的数
            int insertVal = arr[i];
            int insertIndex = i-1;//arr[i]前一个数的下标
            //应为要保证 0 - (i-1) 这部分是有序的
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];//有序表中的数相应前移
                insertIndex --;
            }
            arr[insertIndex+1] = insertVal;//将待插入的值插入有序表
        }
    }

}
