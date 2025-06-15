package typicalAlgorithom.ByteCalculator;

/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 *
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 *
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 *
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC693 {

    //对于 1010 这种位级表示的数，把它向右移动 1 位得到 101，这两个数每个位都不同，因此异或得到的结果为 1111。
    public boolean hasAlternatingBits(int n) {
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        boolean zero = true;
        if((n & 1) == 1){
            zero = false;
        }
        n >>= 1;

        while ( n > 0){
            if(zero){
                if((n & 1) == 1){
                    zero = false;
                    n >>= 1;
                }else {
                    return false;
                }

            }else {
                if((n & 1) == 0){
                    zero = true;
                    n >>=1;
                }else {
                    return false;
                }
            }

        }

        return true;
    }
}
