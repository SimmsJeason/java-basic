package Singleton;

public class SingletonType7 {
    public static void main(String[] args) {
        System.out.println("懒汉式3 ， 线程安全");
        Singleton7 Singleton71 = Singleton7.getInstance();
        Singleton7 Singleton72 = Singleton7.getInstance();

        System.out.println(Singleton71 == Singleton72);
    }
}


//懒汉式（静态内部类）
class Singleton7 {
    private static volatile Singleton7 instance;
    private Singleton7 (){}

    //静态内部类，该类中有一个静态属性Singleton7
    private static class Singleton7Instance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    //提供一个静态的公有方法，直接返回Singleton7Instance.INSTANCE
    public static synchronized Singleton7 getInstance(){
        return Singleton7Instance.INSTANCE;
    }
}