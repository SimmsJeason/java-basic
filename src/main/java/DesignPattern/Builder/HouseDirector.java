package Builder;

//指挥者，这里去指定制作流程
public class HouseDirector {
    HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    //如何处理建造房子的流程，交给指挥者
    public House constructHouse(){
            houseBuilder.buildBasic();
            houseBuilder.buildWalls();
            houseBuilder.roofed();
            return houseBuilder.buildHouse();
    }
}
