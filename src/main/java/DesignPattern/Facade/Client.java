package Facade;

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade facade = new HomeTheaterFacade();
        facade.ready();
    }
}
