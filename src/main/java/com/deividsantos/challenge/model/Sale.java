package com.deividsantos.challenge.model;

import java.util.List;

public class Sale {
    private String saleId;
    private List<Item> items;
    private String salesmanName;

    private Sale(Builder saleBuilder) {
        this.saleId = saleBuilder.saleId;
        this.items = saleBuilder.items;
        this.salesmanName = saleBuilder.salesmanName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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

    public static class Builder {

        private String saleId;
        private List<Item> items;
        private String salesmanName;

        public Builder withId(String saleId) {
            this.saleId = saleId;
            return this;
        }

        public Builder withItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public Builder withSalesmanName(String salesmanName) {
            this.salesmanName = salesmanName;
            return this;
        }

        public Sale build() {
            return new Sale(this);
        }

    }

    @Override
    public String toString() {
        return String.format("Sale ID: %s, Items: %s, Salesman Name: %s", saleId, items, salesmanName);
    }
}
