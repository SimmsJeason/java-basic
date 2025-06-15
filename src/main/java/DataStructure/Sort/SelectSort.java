package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20, -2};

        select(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void select(int [] arr){

        //只需要循环n-1次
        for(int i = 0; i<arr.length -1; i++){
            int mixIndex = i;
            int min = arr[i];

            for(int j = i + 1; j < arr.length  ; j++){
                if(min > arr[j]){
                    min = arr[j];
                    mixIndex = j;
                }
            }

            arr[mixIndex] = arr[i];
            arr[i] = min;
        }

    }

}
