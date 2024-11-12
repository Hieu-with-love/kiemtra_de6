package devzeus.com.kiemtra_ltweb_de6.model;

public class Category {
    private int categoryId;
    private String categoryName;
    private String categoryCode;
    private String images;
    private boolean status;

    public Category() {}

    public Category(int categoryId, String categoryName, String categoryCode, String images, boolean status) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.images = images;
        this.status = status;
    }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getCategoryCode() { return categoryCode; }
    public void setCategoryCode(String categoryCode) { this.categoryCode = categoryCode; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}

