package com.charter.store.dto;

public class CustomerDto {

    private String firstName;
    private String lastName;
    private int numberPurchases;
    private int januaryPoints;
    private int februaryPoints;
    private int marchPoints;
    private int totalPoints;

    public CustomerDto(String firstName, String lastName, int numberPurchases, int januaryPoints,
                       int februaryPoints, int marchPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberPurchases = numberPurchases;
        this.januaryPoints = januaryPoints;
        this.februaryPoints = februaryPoints;
        this.marchPoints = marchPoints;
        this.totalPoints = januaryPoints + februaryPoints + marchPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberPurchases() {
        return numberPurchases;
    }

    public void setNumberPurchases(int numberPurchases) {
        this.numberPurchases = numberPurchases;
    }

    public int getJanuaryPoints() {
        return januaryPoints;
    }

    public void setJanuaryPoints(int januaryPoints) {
        this.januaryPoints = januaryPoints;
    }

    public int getFebruaryPoints() {
        return februaryPoints;
    }

    public void setFebruaryPoints(int februaryPoints) {
        this.februaryPoints = februaryPoints;
    }

    public int getMarchPoints() {
        return marchPoints;
    }

    public void setMarchPoints(int marchPoints) {
        this.marchPoints = marchPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
