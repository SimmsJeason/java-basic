package Bridge;

public class XiaoMi implements Brand {
    public void open() {
        System.out.println("小米手机——>开机");
    }

    public void close() {
        System.out.println("小米手机——>关机");

    }

    public void call() {
        System.out.println("小米手机——>打电话");

    }
}
