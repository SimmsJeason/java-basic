package Builder;

public class CommonHouse extends HouseBuilder {
    public void buildBasic() {
        super.house.setBasic("5米");
        System.out.println("普通来房子，地基 5米");
    }

    public void buildWalls() {
        super.house.setWalls("3米");
        System.out.println("普通房子，墙3米");
    }

    public void roofed() {
        super.house.setRoof("1米");
        System.out.println("普通房子，封顶1米");
    }
}
