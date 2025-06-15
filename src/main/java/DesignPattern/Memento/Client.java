package Memento;

public class Client {
    public static void main(String[] args) {

        //创建角色
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);
        System.out.println("和Boss大战前的状态");
        gameRole.display();

        //把当前状态保存到caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("和Boss大战~~~~");
        gameRole.setDef(30);
        gameRole.setVit(30);

        gameRole.display();

        System.out.println("大战后，使用备忘录对象恢复到大战前");

        gameRole.recoverGameRoleMemento(caretaker.getMemento());

        gameRole.display();

    }
}
