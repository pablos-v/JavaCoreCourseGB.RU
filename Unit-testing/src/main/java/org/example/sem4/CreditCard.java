package org.example.sem4;

import lombok.Data;

import java.util.Date;

public class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expDate;
    private String cvv;

    public CreditCard(String cardNumber, String cardHolder, String expDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expDate = expDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getExpDeate() {
        return expDate;
    }

    public String  getCvv() {
        return cvv;
    }

    public void charge(double amount) {
        System.out.println("Payed");
    }

}
