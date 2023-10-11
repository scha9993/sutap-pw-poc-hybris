package com.sysco.brakes.qe.webui.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private final String cardType;
    private final String cardNo;
    private final String cardHolder;
    private final String expiryDate;
    private final String cvv;
    private final String secretCode;

    // Constructor for each enum constant
    public Card(String cardType, String cardNo, String cardHolder, String expiryDate, String cvv, String secretCode) {
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.secretCode = secretCode;
    }

    // Method to get the last four digits of the card number
    public String getCardStarNumber() {
        return cardNo.substring(cardNo.length() - 4);
    }
}
