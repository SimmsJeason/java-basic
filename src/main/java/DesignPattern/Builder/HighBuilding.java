package Builder;

public class HighBuilding extends HouseBuilder{
    public void buildBasic() {
        super.house.setBasic("20米");
        System.out.println("高楼，地基20米");
    }

    public void buildWalls() {
        super.house.setWalls("100米");
        System.out.println("高楼，墙100米");
    }

    public void roofed() {
        super.house.setRoof("20米");
        System.out.println("高楼，封顶20米");
    }
}
