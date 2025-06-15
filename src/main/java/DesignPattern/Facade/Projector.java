package Facade;

public class Projector {
    //单例模式(饿汉式)
    private static Projector instance = new Projector();

    private Projector(){ }

    public static Projector getInstance(){
        return instance;
    }

    public void on(){
        System.out.println(" Projector on ...");
    }

    public void off(){
        System.out.println(" Popcorn off ...");
    }
}
