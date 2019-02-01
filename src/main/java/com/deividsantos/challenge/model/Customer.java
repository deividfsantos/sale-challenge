package com.deividsantos.challenge.model;

public class Customer {

    private String cnpj;
    private String name;
    private String businessArea;

    private Customer(CustomerBuilder customerBuilder) {
        this.cnpj = customerBuilder.cnpj;
        this.name = customerBuilder.name;
        this.businessArea = customerBuilder.businessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public static class CustomerBuilder {

        private String cnpj;
        private String name;
        private String businessArea;

        public CustomerBuilder withCnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder withBusinessArea(String businessArea) {
            this.businessArea = businessArea;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "cnpj='" + cnpj + '\'' +
                ", name='" + name + '\'' +
                ", businessArea='" + businessArea + '\'' +
                '}';
    }
}
