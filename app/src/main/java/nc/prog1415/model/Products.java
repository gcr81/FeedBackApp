package nc.prog1415.model;

public class Products {

    Integer productid;
     String productName;
     String productInfo;
     Integer imageUrl;

    public Products(Integer productId,String productName,String productInfo, Integer imageUrl) {

        this.productid = productId;
        this.productName = productName;
        this.productInfo = productInfo;
        this.imageUrl = imageUrl;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {  this.productid = productid;
    }
}
