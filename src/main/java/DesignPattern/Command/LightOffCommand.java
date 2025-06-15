package Command;

public class LightOffCommand implements Command {

    LightReceiver receiver;

    public LightOffCommand(LightReceiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        //System.out.println("灯关闭了 。。。");
        receiver.off();
    }

    @Override
    public void undo() {
        //System.out.println("灯打开了 。。。");
        receiver.on();
    }
}
