package Flyweight;

public class Flyweight {
    public static void main(String[] args) {

        /**
         * 如果Integer.valueOf(x)在-127 -- 128之间，使用的是享元模式，
         * 如果不在，则还是使用new 创建新对象
         */
        Integer x = Integer.valueOf(127);
        Integer y = Integer.valueOf(127);

        Integer u = Integer.valueOf(200);
        Integer v = Integer.valueOf(200);

        System.out.println(x == y);

        System.out.println(u == v);
    }
}
