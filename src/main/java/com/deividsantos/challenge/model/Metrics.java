package com.deividsantos.challenge.model;

import java.util.List;

public class Metrics {

    private Integer amountOfClients;
    private Integer amountOfSalesman;
    private List<String> mostExpensiveSale;
    private String worstSalesman;

    public Metrics(Integer amountOfClients, Integer amountOfSalesman, List<String> mostExpensiveSale, String worstSalesman) {
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

    public List<String> getMostExpensiveSale() {
        return mostExpensiveSale;
    }

    public void setMostExpensiveSale(List<String> mostExpensiveSale) {
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
                "\nMost expensive sale ID: " + mostExpensiveSale +
                "\nWorst salesman CNPJ: " + worstSalesman;
    }
}
