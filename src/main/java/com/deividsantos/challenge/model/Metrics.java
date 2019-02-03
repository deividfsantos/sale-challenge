package com.deividsantos.challenge.model;

public class Metrics {

    private Integer amountOfClients;
    private Integer amountOfSalesmen;
    private String mostExpensiveSale;
    private String worstSalesman;

    public Metrics(MetricsBuilder metricsBuilder) {
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

    public static class MetricsBuilder {

        private Integer amountOfClients;
        private Integer amountOfSalesman;
        private String mostExpensiveSale;
        private String worstSalesman;

        public MetricsBuilder withAmountOfClientes(Integer amountOfClients) {
            this.amountOfClients = amountOfClients;
            return this;
        }


        public MetricsBuilder withAmountOfSalesmen(Integer amountOfSalesmen) {
            this.amountOfSalesman = amountOfSalesmen;
            return this;
        }

        public MetricsBuilder withMostExpensiveSale(String mostExpensiveSale) {
            this.mostExpensiveSale = mostExpensiveSale;
            return this;
        }

        public MetricsBuilder withWorstSalesman(String worstSalesman) {
            this.worstSalesman = worstSalesman;
            return this;
        }

        public Metrics build() {
            return new Metrics(this);
        }
    }

    @Override
    public String toString() {
        return "\nMetrics:" +
                "\nAmount of clients: " + amountOfClients +
                "\nAmount of salesmen: " + amountOfSalesmen +
                "\nMost expensive sale: " + mostExpensiveSale +
                "\nWorst salesman: " + worstSalesman;
    }
}
