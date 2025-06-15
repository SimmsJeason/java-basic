package Observer;

public class Client {
    public static void main(String[] args) {
        //创建一个Weather对象
        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentCondition currentCondition = new CurrentCondition();

        //创建百度观察者
        BaiduSite baiduSite = new BaiduSite();

        //将观察者注册到weatherData
        weatherData.registerObserver(currentCondition);

        weatherData.registerObserver(baiduSite);

        weatherData.setData(10f, 100f, 30.3f);

    }
}
