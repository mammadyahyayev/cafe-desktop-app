package model;

import java.util.Date;

public class AdvancedSearch {

    private CafeTable cafeTable;
    private Date beginDate;
    private Date endDate;
    private String minSay;
    private String maxSay;
    private String beginPrice;
    private String endPrice;

    public String getBeginPrice() {
        return beginPrice;
    }

    public void setBeginPrice(String beginPrice) {
        this.beginPrice = beginPrice;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(String endPrice) {
        this.endPrice = endPrice;
    }

    public CafeTable getCafeTable() {
        return cafeTable;
    }

    public void setCafeTable(CafeTable cafeTable) {
        this.cafeTable = cafeTable;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMinSay() {
        return minSay;
    }

    public void setMinSay(String minSay) {
        this.minSay = minSay;
    }

    public String getMaxSay() {
        return maxSay;
    }

    public void setMaxSay(String maxSay) {
        this.maxSay = maxSay;
    }

    @Override
    public String toString() {
        return "AdvancedSearch{" + "cafeTable=" + cafeTable + ", beginDate=" + beginDate + ", endDate=" + endDate + ", minSay=" + minSay + ", maxSay=" + maxSay + ", beginPrice=" + beginPrice + ", endPrice=" + endPrice + '}';
    }

}
