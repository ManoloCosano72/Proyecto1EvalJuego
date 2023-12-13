package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    //El jugador posee un nombre y despues recibira una lista de cartas al inicio y si continua o no
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    //Le da una carta al jugador
    public void addCard(Card card) {
        this.cards.add(card);
    }
}
