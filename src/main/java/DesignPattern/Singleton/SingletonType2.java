package Singleton;

public class SingletonType2 {
    public static void main(String[] args) {

    }


}

//饿汉式（静态代码块）
class Singleton2 {

    private Singleton2(){ }

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public Singleton2 getInstance(){
        return instance;
    }

}