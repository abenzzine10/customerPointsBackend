package com.charter.store.dto;


import java.time.LocalDate;

public class PurchaseDto {

    private String customerFirstName;
    private String customerLastName;
    private LocalDate date;
    private double amount;
    private int points;

    public PurchaseDto(String customerFirstName, String customerLastName, LocalDate date, double amount, int points) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.date = date;
        this.amount = amount;
        this.points = points;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
