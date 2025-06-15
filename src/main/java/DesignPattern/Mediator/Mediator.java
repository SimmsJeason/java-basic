package Mediator;

public abstract class Mediator {
    //将一个中介者对象加入到集合中
    public abstract void register(String colleagueName, Colleague colleague);

    //接收信息，具体的同事对象发出的
    public abstract void getMessage(int stateChange, String colleague);

    public abstract void sendMessage();
}
