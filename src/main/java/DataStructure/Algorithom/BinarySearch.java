package DataStructure.Algorithom;

public class BinarySearch {
    public static void main(String[] args) {
        int [] array = {1,8,10,89,89,89,1000,1234};
        int result = binarySearch(array, 1000);
        System.out.println(result);
    }

    public static int binarySearch(int [] array, int target){
        int left = 0;
        int right = array.length-1;

        while (left <= right){
            int mid = (left + right)/2;
            int midVal = array[mid];

            if(target < midVal){
                right = mid - 1;
            }else if(target > midVal){
                left = mid + 1;
            }else{
               return mid;
            }
        }
        return -1;
    }




}
