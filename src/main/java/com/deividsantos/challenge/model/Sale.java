package com.deividsantos.challenge.model;

public class Sale {

    private String saleId;
    private Item item;
    private String salesmanName;

    public Sale(String saleId, Item item, String salesmanName) {
        this.saleId = saleId;
        this.item = item;
        this.salesmanName = salesmanName;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId='" + saleId + '\'' +
                ", item=" + item +
                ", salesmanName='" + salesmanName + '\'' +
                '}';
    }
}
