package model;

public class MenuIn extends AbstractModel {

    private String menyuInName;
    private Float price;
    private Menu menu;

    public String getMenyuInName() {
        return menyuInName;
    }

    public void setMenyuInName(String menyuInName) {
        this.menyuInName = menyuInName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
