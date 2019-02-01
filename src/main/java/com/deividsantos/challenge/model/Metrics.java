package com.deividsantos.challenge.model;

public class Metrics {

    private Integer amountOfClients;
    private Integer amountOfSalesman;
    private String mostExpensiveSale;
    private String worstSalesman;

    public Metrics(Integer amountOfClients, Integer amountOfSalesman, String mostExpensiveSale, String worstSalesman) {
        this.amountOfClients = amountOfClients;
        this.amountOfSalesman = amountOfSalesman;
        this.mostExpensiveSale = mostExpensiveSale;
        this.worstSalesman = worstSalesman;
    }

    public Integer getAmountOfClients() {
        return amountOfClients;
    }

    public void setAmountOfClients(Integer amountOfClients) {
        this.amountOfClients = amountOfClients;
    }

    public Integer getAmountOfSalesman() {
        return amountOfSalesman;
    }

    public void setAmountOfSalesman(Integer amountOfSalesman) {
        this.amountOfSalesman = amountOfSalesman;
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

    @Override
    public String toString() {
        return "\nMetrics:" +
                "\nAmount of clients: " + amountOfClients +
                "\nAmount of salesmen: " + amountOfSalesman +
                "\nMost expensive sale: " + mostExpensiveSale +
                "\nWorst salesman: " + worstSalesman;
    }
}
