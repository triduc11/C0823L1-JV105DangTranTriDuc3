package triduc.com.final_exam.model;

public class ProductCategory {
    private int id ;
    private String category ;

    public ProductCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public ProductCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
