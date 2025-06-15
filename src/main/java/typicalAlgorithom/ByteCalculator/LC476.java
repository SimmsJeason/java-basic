package typicalAlgorithom.ByteCalculator;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2:
 *
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *  
 *
 * 注意:
 *
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC476 {
    // 000101  与 000111进行异或就可得到结果
    //所以问题转化为 求 掩码： 000111
    public int findComplement(int num) {

        if(num == 0) return 1;

        int mask = 1<<30;

        //找到最左边的那个1
        while((num & mask) == 0) mask >>= 1;

        mask = (mask<<1) -1;//得到掩码
        return num ^ mask;
    }
}
