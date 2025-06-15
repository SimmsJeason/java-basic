package Adapter.ObjectAdapter;

//适配器类
public class VoltaAdapter implements IVoltage {

    private Voltage220V voltage220V;

    public VoltaAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    public int output5V() {
        //获取到220v的电压

        int dst = 0;

        if(voltage220V != null){

            int src = voltage220V.output220V();
            dst = src / 44;
            System.out.println("适配完成，输出的电压为： " + dst);
        }

        return dst;
    }
}
