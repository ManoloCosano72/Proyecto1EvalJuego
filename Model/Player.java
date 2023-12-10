package Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

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

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void clearCards() {
        this.cards.clear();
    }
}
