package Observer;

public class BaiduSite implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //显示
    public void display(){
        System.out.println("****百度当前的温度为：   " + temperature + " ******");
        System.out.println("****百度当前的气压为：   " + pressure + " ******");
        System.out.println("****百度当前的湿度为：   " + humidity + " ******");
    }
}
