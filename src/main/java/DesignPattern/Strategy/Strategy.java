package Strategy;

        import java.util.Arrays;
        import java.util.Comparator;

public class Strategy {
    public static void main(String[] args) {
        Integer [] data = {9,1,2,3,8,4};
        /**
         * 1.实现了Comparator接口（策略接口），匿名类对象new Comparator<Integer>(){}
         * 2.对象new Comparator<Integer>(){...}就是实现了策略接口的对象
         * 3.public int compare(Integer o1, Integer o2){}指定具体的处理方式
         */

        /**
         * 方式一
         */
        Comparator<Integer> comparator = new Comparator<Integer>(){
            public int compare (Integer o1, Integer o2){
                if(o1 > o2){
                    return 1;
                }else {
                    return -1;
                }
            }
        };

        /**
         *   public static <T> void sort(T[] a, Comparator<? super T> c) {
         *         if (c == null) {
         *             sort(a);//默认方法
         *         } else {
         *             if (LegacyMergeSort.userRequested)
         *                 legacyMergeSort(a, c);//使用策略对象c
         *             else
         *             //使用策略对象c
         *                 TimSort.sort(a, 0, a.length, c, null, 0, 0);
         *         }
         *     }
         */
        Arrays.sort(data, comparator);

        /**
         * -----------------------方式2-----------------------------
         */

        //升序
        Arrays.sort(data, (var1, var2)->{
            if( var1.compareTo(var2) > 0){
                return 1;
            }else {
                return -1;
            }
        } );
        System.out.println(Arrays.toString(data));
    }
}
