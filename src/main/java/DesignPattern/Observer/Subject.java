package Observer;

public interface Subject {
    //注册观察者
    public void registerObserver(Observer o);

    //移除观察者
    public void remove(Observer o);

    //
    public void notifyObserver();

}
