package duc.com.demo_product.dto;

public class ProductDto {
    private int id ;
    private String name ;
    private float price ;
    private int amount ;
    private String size ;

    public ProductDto() {
    }

    public ProductDto(int id, String name, float price, int amount, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.size = size;
    }

    public ProductDto(float price, int amount, String size) {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
