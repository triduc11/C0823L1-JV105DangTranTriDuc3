package duc.com.demo_product.model;

public class ProductSize {
    private int id ;
    private String size ;

    public ProductSize() {
    }

    public ProductSize(int id, String size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
