package Search;

public class insertValueSearch {
    public static void main(String[] args) {

        int [] array = new int[100];
        for(int i = 0; i< 100; i++){
            array[i] = i+1;
        }
        int result = insertValueSearch(array, 0, 99, 50);
        System.out.println(result);
    }
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        //注意：因为数组是有序的，所以 findVal < arr[0]  和  findVal > arr[arr.length - 1] 可以提前终止,而且必须存在
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal) { // 向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
