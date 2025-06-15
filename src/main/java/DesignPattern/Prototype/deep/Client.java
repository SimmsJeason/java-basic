package Prototype.deep;

public class Client {
    public static void main(String[] args) {
        DeepPrototype p = new DeepPrototype();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("李逵", "武松");

        DeepPrototype p2 = p.deepClone();
        System.out.println(p.name + "  " + p.deepCloneableTarget.hashCode());
        System.out.println(p2.name + "  " + p2.deepCloneableTarget.hashCode());
    }
}
