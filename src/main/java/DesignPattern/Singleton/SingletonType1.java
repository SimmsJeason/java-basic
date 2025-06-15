package Singleton;

public class SingletonType1 {
    public static void main(String[] args) {

    }


}

//饿汉式（静态常量）
class Singleton1 {

    private Singleton1(){ }

    private final static Singleton1 instance = new Singleton1();

    public Singleton1 getInstance(){
        return instance;
    }

}


