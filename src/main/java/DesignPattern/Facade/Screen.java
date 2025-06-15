package Facade;

public class Screen {
    //单例模式(饿汉式)
    private static Screen instance = new Screen();

    private Screen(){ }

    public static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println(" Screen up ...");
    }

    public void down(){
        System.out.println(" Screen down ...");
    }
}
