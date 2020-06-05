
package model;


public class Product extends AbstractModel{
    private String productName;
    private int say;
    private Float price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSay() {
        return say;
    }

    public void setSay(int say) {
        this.say = say;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
}
