package Adapter.ObjectAdapter;

public class Phone {

    //充电
    public void charging(IVoltage iVoltage){
        if(iVoltage.output5V() == 5){
            System.out.println("电压为5V，可以充电");
        }else if(iVoltage.output5V() > 5){
            System.out.println("电压大于5V，不能进行充电");
        }

    }
}
