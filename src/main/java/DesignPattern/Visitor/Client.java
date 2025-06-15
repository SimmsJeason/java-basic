package Visitor;

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        //
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        //success
        Success success = new Success();

        objectStructure.display(success);
    }
}
