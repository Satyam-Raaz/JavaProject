package beans;

public class Order {
    private long productId;
    private int qty;
    private double price;
    private String deliveredDay;
    private String email;


    public Order(long productId,double price,int qty,String email){
        super();
        this.productId=productId;
        this.price=price;
        this.qty=qty;
        this.email=email;
    }
    public Order(){super();}

    public long getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeliveredDay() {
        return "Within Seven days";
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [ProductId=" + productId + ", Quantity=" + qty + ", Delivered=" + getDeliveredDay() + ", price=" + price + "]";
    }
}
