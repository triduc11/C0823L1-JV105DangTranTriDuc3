package duc.com.demo_product.model;

public class Product {
    private int id ;
    private String name ;
    private float price ;
    private int amount ;
    private int size ;

    public Product() {
    }

    public Product(int id, String name, float price, int amount, int size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
    }

    public Product(String name, float price, int amount, int size) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
