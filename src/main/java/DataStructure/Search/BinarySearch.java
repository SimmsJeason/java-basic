package Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {

        int [] array = {1,8,10,89,89,89,1000,1234};
        List<Integer> list = binary2(array, 0, 5, 89);
        for(Integer i: list){
            System.out.print(i + " ");
        }
    }

    public static void binary(int [] array, int left, int right, int finalVal){
        int mid = (left + right) /2;
        int midVal = array[mid];
        if(left <= right){
            if(finalVal < midVal){
                binary(array, left, mid -1, finalVal);
            }else if(finalVal > midVal){
                binary(array, mid + 1, right, finalVal);
            }else {
                System.out.println("该数的位置是 " + mid);
            }
        }else {
            System.out.println("没有找到");
        }
    }

    public static List<Integer> binary2(int [] array, int left, int right, int finalVal){

        if(left > right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right) /2;
        int midVal = array[mid];

        if(finalVal < midVal){
            return binary2(array, left, mid -1, finalVal);
        }else if(finalVal > midVal){
            return binary2(array, mid + 1, right, finalVal);
        }else {
            List<Integer> resIndexList = new ArrayList<Integer>();
            int tmp = mid -1 ;
            while (true){
                if(tmp < 0 || array[tmp] != finalVal){
                    break;
                }

                resIndexList.add(tmp);
                tmp --;//tmp 左移
            }

            resIndexList.add(mid);

            tmp = mid + 1;
            while (true){
                if(tmp > array.length-1 || array[tmp] != finalVal){
                    break;
                }

                resIndexList.add(tmp);
                tmp ++;//tmp 左移
            }

            return resIndexList;
        }
    }
}
