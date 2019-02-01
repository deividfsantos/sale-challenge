package com.deividsantos.challenge.model;

import java.math.BigDecimal;

public class Item {
    private String id;
    private Long quantity;
    private BigDecimal price;

    private Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.id;
        this.quantity = itemBuilder.quantity;
        this.price = itemBuilder.price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static class ItemBuilder {
        private String id;
        private Long quantity;
        private BigDecimal price;

        public ItemBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withQuantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public ItemBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
