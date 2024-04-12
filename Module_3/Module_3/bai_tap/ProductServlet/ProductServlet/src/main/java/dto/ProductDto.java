package dto;

public class ProductDto {

    private int id;
    private String name;
    private float price;
    private String description;
    private String manufactor;

    public ProductDto() {
    }

    public ProductDto(int id, String name, float price, String description, String manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactor = manufactor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }
}
