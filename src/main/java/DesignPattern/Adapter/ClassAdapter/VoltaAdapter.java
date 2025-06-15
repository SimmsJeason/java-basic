package DesignPattern.Adapter.ClassAdapter;

//适配器类
public class VoltaAdapter extends Voltage220V implements IVoltage{

    public int output5V() {
        //获取到220v的电压
        int src = output220V();
        int targetV = src / 44;
        return targetV;
    }
}
