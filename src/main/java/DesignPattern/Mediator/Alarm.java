package Mediator;

//具体的同事类
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);

    }

    @Override
    public void sendMessage() {

    }
}
