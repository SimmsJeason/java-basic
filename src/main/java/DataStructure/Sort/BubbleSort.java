package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20, -2};
        int tmp =0;
        boolean flag = false;

        for(int j = 0; j<arr.length - 1; j++){
            for(int i = 0 ; i < arr.length-j-1; i++){
                if(arr[i] > arr[i+1]){
                    flag = true;
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }

            if(!false){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
