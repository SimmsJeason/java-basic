package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1。包含最新的天气信息
 * 2.含有观察者集合，使用ArrayList
 * 3.当有数据更新时，主动调用ArrayList,通知所有接入方就看到最新消息
 */
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;

    List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void dataChange(){
        notifyObserver();
    }

    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //将最新的信息推送给接收方
        dataChange();
    }

    //添加一个观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    //移除一个观察者
    @Override
    public void remove(Observer o) {

        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    //遍历所有的观察者，并通知
    @Override
    public void notifyObserver() {
        observers.forEach(observer ->
            observer.update(temperature, pressure, humidity));
    }
}
