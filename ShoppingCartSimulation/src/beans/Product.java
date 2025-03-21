package beans;

public class Product {
    private long id;
    private String productName;
    private String productType;
    private int stock;
    private double price;

    public Product(long id,String productName,String productType,double price,int stock){
        super();
        this.id=id;
        this.productName=productName;
        this.productType=productType;
        this.price=price;
        this.stock=stock;
    }
    public Product(){super();}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + productName + ", type=" + productType + ", price=" + price + ", stock=" + stock
                + "]";
    }
}
