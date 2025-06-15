package ReponsibilityChain;

public class PurchaseRequest {
    private int type = 0;
    private int id = 0;
    private float price = 0.0f;

    public PurchaseRequest(int type, int id, float price) {
        this.type = type;
        this.id = id;
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
