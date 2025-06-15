package Command;

public class LightOnCommand implements Command {

    LightReceiver receiver;

    public LightOnCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //System.out.println("灯打开了 。。。");
        receiver.on();
    }

    @Override
    public void undo() {
        //System.out.println("灯关闭了 。。。");
        receiver.off();
    }
}
