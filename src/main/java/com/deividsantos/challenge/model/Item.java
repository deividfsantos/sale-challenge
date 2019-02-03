package com.deividsantos.challenge.model;

import java.math.BigDecimal;

public class Item {
    private String id;
    private Long quantity;
    private BigDecimal price;

    private Item(Builder itemBuilder) {
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

    public static class Builder {
        private String id;
        private Long quantity;
        private BigDecimal price;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withQuantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }

    @Override
    public String toString() {
        return String.format("Item ID: %s, Quantity: %s, Price: %s", id, quantity, price);
    }
}
