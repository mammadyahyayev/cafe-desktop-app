
package model;

import java.util.Date;


public class Sifaris_Masa extends AbstractModel{
    private CafeTable cafeTable;
    private Sifaris sifaris;
    private Date orderDate;

    public CafeTable getCafeTable() {
        return cafeTable;
    }

    public void setCafeTable(CafeTable cafeTable) {
        this.cafeTable = cafeTable;
    }

    public Sifaris getSifaris() {
        return sifaris;
    }

    public void setSifaris(Sifaris sifaris) {
        this.sifaris = sifaris;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
