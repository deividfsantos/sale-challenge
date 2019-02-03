package com.deividsantos.challenge.model;

public class Metrics {

    private Integer amountOfClients;
    private Integer amountOfSalesmen;
    private String mostExpensiveSale;
    private String worstSalesman;

    public Metrics(Builder metricsBuilder) {
        this.amountOfClients = metricsBuilder.amountOfClients;
        this.amountOfSalesmen = metricsBuilder.amountOfSalesman;
        this.mostExpensiveSale = metricsBuilder.mostExpensiveSale;
        this.worstSalesman = metricsBuilder.worstSalesman;
    }

    public Integer getAmountOfClients() {
        return amountOfClients;
    }

    public void setAmountOfClients(Integer amountOfClients) {
        this.amountOfClients = amountOfClients;
    }

    public Integer getAmountOfSalesmen() {
        return amountOfSalesmen;
    }

    public void setAmountOfSalesmen(Integer amountOfSalesmen) {
        this.amountOfSalesmen = amountOfSalesmen;
    }


    public String getMostExpensiveSale() {
        return mostExpensiveSale;
    }

    public void setMostExpensiveSale(String mostExpensiveSale) {
        this.mostExpensiveSale = mostExpensiveSale;
    }

    public String getWorstSalesman() {
        return worstSalesman;
    }

    public void setWorstSalesman(String worstSalesman) {
        this.worstSalesman = worstSalesman;
    }

    public static class Builder {

        private Integer amountOfClients;
        private Integer amountOfSalesman;
        private String mostExpensiveSale;
        private String worstSalesman;

        public Builder withAmountOfClientes(Integer amountOfClients) {
            this.amountOfClients = amountOfClients;
            return this;
        }


        public Builder withAmountOfSalesmen(Integer amountOfSalesmen) {
            this.amountOfSalesman = amountOfSalesmen;
            return this;
        }

        public Builder withMostExpensiveSale(String mostExpensiveSale) {
            this.mostExpensiveSale = mostExpensiveSale;
            return this;
        }

        public Builder withWorstSalesman(String worstSalesman) {
            this.worstSalesman = worstSalesman;
            return this;
        }

        public Metrics build() {
            return new Metrics(this);
        }
    }

    @Override
    public String toString() {
        return "Metrics" +
                "\nAmount of clients: " + amountOfClients +
                "\nAmount of salesmen: " + amountOfSalesmen +
                "\nMost expensive sale: " + mostExpensiveSale +
                "\nWorst salesman: " + worstSalesman;
    }
}
