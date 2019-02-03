package com.deividsantos.challenge.model;

import java.util.Optional;

public class Metrics {

    private Integer amountOfClients;
    private Integer amountOfSalesmen;
    private Sale mostExpensiveSale;
    private Salesman worstSalesman;

    public Metrics(Builder metricsBuilder) {
        this.amountOfClients = metricsBuilder.amountOfClients;
        this.amountOfSalesmen = metricsBuilder.amountOfSalesman;
        this.mostExpensiveSale = metricsBuilder.mostExpensiveSale;
        this.worstSalesman = metricsBuilder.worstSalesman;
    }

    public static class Builder {
        private Integer amountOfClients;
        private Integer amountOfSalesman;
        private Sale mostExpensiveSale;
        private Salesman worstSalesman;

        public Builder withAmountOfClientes(Integer amountOfClients) {
            this.amountOfClients = amountOfClients;
            return this;
        }


        public Builder withAmountOfSalesmen(Integer amountOfSalesmen) {
            this.amountOfSalesman = amountOfSalesmen;
            return this;
        }

        public Builder withMostExpensiveSale(Sale mostExpensiveSale) {
            this.mostExpensiveSale = mostExpensiveSale;
            return this;
        }

        public Builder withWorstSalesman(Salesman worstSalesman) {
            this.worstSalesman = worstSalesman;
            return this;
        }

        public Metrics build() {
            return new Metrics(this);
        }
    }

    public String getSummarized() {
        return "Amount of clients: " + amountOfClients +
                "\nAmount of salesmen: " + amountOfSalesmen +
                "\nMost expensive sale ID: " + getSaleId() +
                "\nWorst salesman CPF: " + getSalesmanName();
    }

    private String getSaleId() {
        return Optional.ofNullable(mostExpensiveSale)
                .map(Sale::getSaleId)
                .orElse("There are no sales.");
    }

    private String getSalesmanName() {
        return Optional.ofNullable(worstSalesman)
                .map(Salesman::getCpf)
                .orElse("There are no salesmen.");
    }
}
