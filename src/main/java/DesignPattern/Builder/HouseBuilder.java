package Builder;


public abstract class HouseBuilder {
    House house = new House();

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建好房子，将房子返回
    public House buildHouse(){
        return house;
    }

}
