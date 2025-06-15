package Command;

//符合开闭原则

public class RemoteController {
    //开关命令组
    Command [] onCommands ;
    Command [] offCommands ;

    //撤销命令
    Command undoCommand ;

    //构造器，完成对按钮的初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i = 0; i<5; i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给我们的按钮设置需要的命令
    public void setCommand(int num, Command onCommand, Command offCommand){
        onCommands[num] = onCommand;
        offCommands[num] = offCommand;
    }

    //按下开按钮
    public void onButtonWasPushed(int num){
        //找到你按下开的按钮，并调用对应的方法
        onCommands[num].execute();
        //记录这次操作，用于撤销
        undoCommand = onCommands[num];
    }

    //按下关按钮
    public void offButtonWasPushed(int num){
        //找到你按下关的按钮，并调用对应的方法
        offCommands[num].execute();
        //记录这次操作，用于撤销
        undoCommand = offCommands[num];
    }

    //按下撤销按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
