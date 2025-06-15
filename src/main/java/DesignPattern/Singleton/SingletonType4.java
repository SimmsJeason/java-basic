package Singleton;

public class SingletonType4 {
    public static void main(String[] args) {

    }
}

//懒汉式（同步方法）
class Singleton4{
    private static Singleton4 instance;

    private Singleton4(){ }

    //提供一个静态公共方法，当使用该方法时才去创建instance

    /*public static synchronized Singleton4 getInstance(){
        if(instance == null)
            instance = new Singleton4();
        return instance;
    }*/

    //同步代码块方式
    public static  Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                instance = new Singleton4();
            }
        }

        return instance;
    }
}