package DesignPattern.Adapter.ClassAdapter;


import DesignPattern.Adapter.ClassAdapter.Phone;
import DesignPattern.Adapter.ClassAdapter.VoltaAdapter;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltaAdapter());
    }
}
