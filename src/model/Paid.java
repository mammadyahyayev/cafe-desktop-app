package model;

import java.util.Date;

public class Paid extends AbstractModel {

    private Sifaris_Masa sifarisMasa;
    private Float price;
    private Date paidDate;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Sifaris_Masa getSifarisMasa() {
        return sifarisMasa;
    }

    public void setSifarisMasa(Sifaris_Masa sifarisMasa) {
        this.sifarisMasa = sifarisMasa;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

}
