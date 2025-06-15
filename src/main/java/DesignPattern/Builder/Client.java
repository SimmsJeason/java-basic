package Builder;

public class Client {
    public static void main(String[] args) {

        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //盖高楼
        HighBuilding highBuilding = new HighBuilding();

        //准备创建房子的指挥者
        HouseDirector director = new HouseDirector(highBuilding);
        //完成盖房
        House house = director.constructHouse();
        System.out.println(house.toString());
    }
}
