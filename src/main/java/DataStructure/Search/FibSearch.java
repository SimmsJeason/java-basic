package Search;

import java.util.Arrays;

public class FibSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int [] array = {1,8,10,89,89,89,1000,1234};
        fibSearch(array, 1000);
    }

    public static int [] fibonacci(){
        int []f = new int[maxSize];

        f[0] = 1;
        f[1] = 1;

         for(int i = 2; i < maxSize; i++){
               f[i] = f[i-1] + f[i-2];
         }

     return f;
    }

    public static int fibSearch(int [] array, int key){
        int low = 0;
        int high = array.length-1;
        int k = 0;//表示斐波那契分割数值的下标
        int  mid = 0;//存放mid值
        int [] fib = fibonacci();

        //先将数组扩充到满足斐波那契数的长度，即数组的长度要是一个斐波那契数，这个数是 >=high 的
        while(fib[k] < high){
            k++;
        }

        int[]  tmp = Arrays.copyOf(array, fib[k]);
        //当tmp比 array长时，tmp多出来的数用array最后一个数填充
        for(int i = high+1; i<tmp.length; i++){
            tmp[i] = array[high];
        }

        //开始查找

        while(low <= high){
            mid = low + fib[k-1]-1;

            if(key < tmp[mid]){
                high = mid -1;
                /**
                 * 1.全部元素 = 前面元素 + 后边元素
                 * 2.fib[k] = fib[k-1] + fib[k-2]
                 * 因为前面有fib[k-1]个元素，所以可以继续拆分成 fib[k-1]= fib[k-2]+fib[k-3]
                 * 即在fib[k-1]的前面继续查找k--
                 * 即下次循环mid = fib[k-1-1]-1
                 */
                k--;
            }else if( key > tmp[mid]){
                low = mid +1;
                /**
                 * 1.全部元素 = 前面元素 + 后边元素
                 * 2.fib[k] = fib[k-1] + fib[k-2]
                 * 因为前面有fib[k-2]个元素，所以可以继续拆分成 fib[k-2]= fib[k-3]+fib[k-4]
                 * 即在fib[k-2]的前面继续查找k--
                 * 即下次循环mid = fib[k-2-1]-1
                 */
                k-= 2;
            }else{
                if( mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return  -1;//没有找到
    }
}
