package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        cards.add(new Card(1, "A", "Spades"));
        cards.add(new Card(2, "2", "Spades"));
        cards.add(new Card(3, "3", "Spades"));
        cards.add(new Card(4, "4", "Spades"));
        cards.add(new Card(5, "5", "Spades"));
        cards.add(new Card(6, "6", "Spades"));
        cards.add(new Card(7, "7", "Spades"));
        cards.add(new Card(8, "8", "Spades"));
        cards.add(new Card(9, "9", "Spades"));
        cards.add(new Card(10, "J", "Spades"));
        cards.add(new Card(10, "Q", "Spades"));
        cards.add(new Card(10, "K", "Spades"));
        cards.add(new Card(1, "A", "Diamonds"));
        cards.add(new Card(2, "2", "Diamonds"));
        cards.add(new Card(3, "3", "Diamonds"));
        cards.add(new Card(4, "4", "Diamonds"));
        cards.add(new Card(5, "5", "Diamonds"));
        cards.add(new Card(6, "6", "Diamonds"));
        cards.add(new Card(7, "7", "Diamonds"));
        cards.add(new Card(8, "8", "Diamonds"));
        cards.add(new Card(9, "9", "Diamonds"));
        cards.add(new Card(10, "J", "Diamonds"));
        cards.add(new Card(10, "Q", "Diamonds"));
        cards.add(new Card(10, "K", "Diamonds"));
        cards.add(new Card(1, "A", "Hearts"));
        cards.add(new Card(2, "2", "Hearts"));
        cards.add(new Card(3, "3", "Hearts"));
        cards.add(new Card(4, "4", "Hearts"));
        cards.add(new Card(5, "5", "Hearts"));
        cards.add(new Card(6, "6", "Hearts"));
        cards.add(new Card(7, "7", "Hearts"));
        cards.add(new Card(8, "8", "Hearts"));
        cards.add(new Card(9, "9", "Hearts"));
        cards.add(new Card(10, "J", "Hearts"));
        cards.add(new Card(10, "Q", "Hearts"));
        cards.add(new Card(10, "K", "Hearts"));
        cards.add(new Card(1, "A", "Clubs"));
        cards.add(new Card(2, "2", "Clubs"));
        cards.add(new Card(3, "3", "Clubs"));
        cards.add(new Card(4, "4", "Clubs"));
        cards.add(new Card(5, "5", "Clubs"));
        cards.add(new Card(6, "6", "Clubs"));
        cards.add(new Card(7, "7", "Clubs"));
        cards.add(new Card(8, "8", "Clubs"));
        cards.add(new Card(9, "9", "Clubs"));
        cards.add(new Card(10, "J", "Clubs"));
        cards.add(new Card(10, "Q", "Clubs"));
        cards.add(new Card(10, "K", "Clubs"));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card takeCard() {
        Card result = cards.get(0);
        cards.remove(0);
        return result;
    }
}
