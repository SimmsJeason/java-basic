package Bridge;

public class Vivo implements Brand {
    public void open() {
        System.out.println("Vivo 手机——>开机");
    }

    public void close() {
        System.out.println("Vivo 手机——>关机");

    }

    public void call() {
        System.out.println("Vivo 手机——>打电话");

    }
}
