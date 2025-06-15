package Command;

public class Client {
    public static void main(String[] args) {

        //使用命令模式，完成通过遥控器对电灯的控制

        //创建一个电灯对象(命令的接收者)
        LightReceiver receiver = new LightReceiver();

        //创建电灯开关的相关命令
        LightOnCommand onCommand = new LightOnCommand(receiver);
        LightOffCommand offCommand = new LightOffCommand(receiver);

        //创建一个遥控器
        RemoteController controller = new RemoteController();

        //给我们遥控器设置命令， num=0的设备开启
        controller.setCommand(0, onCommand, offCommand);

        //按下按钮，执行操作
        //电灯开
        controller.onButtonWasPushed(0);
        //电灯关
        controller.offButtonWasPushed(0);
        //撤销
        controller.undoButtonWasPushed();

        /*---------------------------------------------*/
        System.out.println("------------------------------------------");

        TVReceiver receiver1 = new TVReceiver();
        TVOnCommand tvOnCommand = new TVOnCommand(receiver1);
        TVOffCommand tvOffCommand = new TVOffCommand(receiver1);
        controller.setCommand(1, tvOnCommand, tvOffCommand);

        controller.onButtonWasPushed(1);
        controller.offButtonWasPushed(1);
        controller.undoButtonWasPushed();
    }
}
