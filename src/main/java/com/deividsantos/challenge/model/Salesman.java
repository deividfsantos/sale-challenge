package com.deividsantos.challenge.model;

import java.math.BigDecimal;

public class Salesman {

    private String cpf;
    private String name;
    private BigDecimal salary;

    private Salesman(SalesmanBuilder salesmanBuilder) {
        this.cpf = salesmanBuilder.cpf;
        this.name = salesmanBuilder.name;
        this.salary = salesmanBuilder.salary;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static class SalesmanBuilder {

        private String cpf;
        private String name;
        private BigDecimal salary;

        public SalesmanBuilder withCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public SalesmanBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SalesmanBuilder withSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Salesman build() {
            return new Salesman(this);
        }

    }

    @Override
    public String toString() {
        return "Salesman{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
