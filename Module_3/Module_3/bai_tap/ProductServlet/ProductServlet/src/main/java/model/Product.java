package model;

public class Product {
    private int id ;
    private String name;
    private float  price;
    private String description;
    private int manufactor;

    public Product() {
    }

    public Product(int id, String name, float price, String description, int manufactor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufactor = manufactor;
    }
    public Product( String name, float price, String description, int manufactor) {
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

    public int getManufactor() {
        return manufactor;
    }

    public void setManufactor(int manufactor) {
        this.manufactor = manufactor;
    }
}
