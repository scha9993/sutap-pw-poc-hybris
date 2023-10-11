package com.sysco.brakes.qe.webui.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sysco.brakes.qe.webui.model.Card;
import com.sysco.brakes.qe.webui.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CardData {
    private String cardType;
    private String cardNumber;
    private String cardName;
    private String expiryDate;
    private String cvv;
    private String secretCode;
    private List<Card> cards;

    public CardData(String filename) throws IOException {
        JsonObject data = JsonUtil.getJsonData(filename);
        cards = new ArrayList<>();
        JsonArray cardsArray = data.getAsJsonArray("Cards");

        for (int i = 0; i < cardsArray.size(); i++) {
            JsonObject cardObject = cardsArray.get(i).getAsJsonObject();
            this.cardType = cardObject.get("cardType").getAsString();
            this.cardNumber = cardObject.get("cardNumber").getAsString();
            this.cardName = cardObject.get("cardName").getAsString();
            this.expiryDate = cardObject.get("expiryDate").getAsString();
            this.cvv = cardObject.get("cvv").getAsString();
            this.secretCode = cardObject.get("secretCode").getAsString();
            cards.add(new Card(cardType, cardNumber, cardName, expiryDate, cvv, secretCode));
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
