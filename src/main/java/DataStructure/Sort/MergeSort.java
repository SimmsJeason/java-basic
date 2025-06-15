package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int [] arr = {9,8,7,6,5,4,3,2,1};
        int [] tmp = new int[arr.length];
        mergeSort(arr, 0, 8, tmp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左边有序序列当前元素的下标
        int j = mid+1;//右边有序序列当前元素的下标
        int t = 0;//temp数组当前元素的下标
        while (i<=mid && j<=right){
            //如果左边的较小，将左边元素入temp
            if(arr[i]<=arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {//反之
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //若左区间有剩余元素
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        //若右区间有剩余元素
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将temp中是值全部拷贝入arr
        t = 0;
        int tempLeft = left;//从左边开始拷贝
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

}
