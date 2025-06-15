package Mediator;

import java.util.HashMap;

public class ConcreteMediator extends Mediator{

    //集合，放入了所有的同事对象
    private HashMap<String, Colleague> colleagueHashMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueHashMap = new HashMap<String, Colleague>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {

    }

    @Override
    public void getMessage(int stateChange, String colleague) {

    }

    @Override
    public void sendMessage() {

    }
}
