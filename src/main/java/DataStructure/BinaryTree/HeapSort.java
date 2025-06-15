package BinaryTree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int [] arr = {4,5,6,8,9,-1,-99};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //堆排序
    public static void heapSort(int [] array){

        int tmp = 0;
        //1. 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for(int i = array.length/2 -1; i>=0; i--){
            adjustHeap(array, i, array.length);
        }

        //2. 将堆顶元素与末尾元素互换，将最大元素放到数组的末尾
        for( int j = array.length - 1; j>=0; j--){
            tmp = array[j];
            array[j] = array[0];
            array[0] = tmp;
            adjustHeap(array, 0, j);
        }
    }
    /***
     *
     * @param array 需要调整的数组
     * @param i 非叶子结点在数组中的位置
     * @param length 表示对多少个元素继续调整，length 是逐渐减少的
     */
    public static void adjustHeap(int [] array, int i, int length){

        int tmp = array[i];

        //k = 2*i +1 表示i结点的左子结点
        for(int k = 2*i +1; k<length; k = k*2+1){

            if((k + 1) < length && array[k] < array[k+1]){//左子结点小于右子结点
                k++;
            }

            if(array[k] > tmp){//如果子结点大于父节点
                array[i] = array[k];
                i = k;
            }else {
                break;
            }

            //当for循环结束时，已经将父节点调整为最大数了,需要将替换父节点的结点填入父节点的值，视作两个值的交换
            array[i] = tmp;
        }
    }
}
