package Facade;

public class TheaterLight {
    //单例模式(饿汉式)
    private static TheaterLight instance = new TheaterLight();

    private TheaterLight(){ }

    public static TheaterLight getInstance(){
        return instance;
    }

    public void dim(){
        System.out.println(" TheaterLight dim ...");
    }

    public void bright(){
        System.out.println(" TheaterLight bright ...");
    }
}
