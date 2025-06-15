package Singleton;

public class SingletonType8 {

    public static void main(String[] args) {
        System.out.println("懒汉式3 ， 线程安全");
        Singleton8 Singleton81 = Singleton8.INSTANCE;
        Singleton8 Singleton82 = Singleton8.INSTANCE;

        System.out.println(Singleton81 == Singleton82);
    }
}


//枚举方式
enum Singleton8{
    INSTANCE;
    public void sayOk(){
        System.out.println("OK ~");
    }
}