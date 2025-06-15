package Adapter.ObjectAdapter;



public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        // 对象适配器
        phone.charging(new VoltaAdapter(new Voltage220V()));
    }
}
