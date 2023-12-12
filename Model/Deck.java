package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private List<Card> cards;

    public Deck() {
        //Aqui esta la lista de todas las cartas del mazo
        cards = new ArrayList<Card>();

        cards.add(new Card(1, "A", "♠"));
        cards.add(new Card(2, "2", "♠"));
        cards.add(new Card(3, "3", "♠"));
        cards.add(new Card(4, "4", "♠"));
        cards.add(new Card(5, "5", "♠"));
        cards.add(new Card(6, "6", "♠"));
        cards.add(new Card(7, "7", "♠"));
        cards.add(new Card(8, "8", "♠"));
        cards.add(new Card(9, "9", "♠"));
        cards.add(new Card(10, "10", "♠"));
        cards.add(new Card(10, "J", "♠"));
        cards.add(new Card(10, "Q", "♠"));
        cards.add(new Card(10, "K", "♠"));

        cards.add(new Card(1, "A", "♦"));
        cards.add(new Card(2, "2", "♦"));
        cards.add(new Card(3, "3", "♦"));
        cards.add(new Card(4, "4", "♦"));
        cards.add(new Card(5, "5", "♦"));
        cards.add(new Card(6, "6", "♦"));
        cards.add(new Card(7, "7", "♦"));
        cards.add(new Card(8, "8", "♦"));
        cards.add(new Card(9, "9", "♦"));
        cards.add(new Card(10, "10", "♦"));
        cards.add(new Card(10, "J", "♦"));
        cards.add(new Card(10, "Q", "♦"));
        cards.add(new Card(10, "K", "♦"));

        cards.add(new Card(1, "A", "♥"));
        cards.add(new Card(2, "2", "♥"));
        cards.add(new Card(3, "3", "♥"));
        cards.add(new Card(4, "4", "♥"));
        cards.add(new Card(5, "5", "♥"));
        cards.add(new Card(6, "6", "♥"));
        cards.add(new Card(7, "7", "♥"));
        cards.add(new Card(8, "8", "♥"));
        cards.add(new Card(9, "9", "♥"));
        cards.add(new Card(10, "10", "♥"));
        cards.add(new Card(10, "J", "♥"));
        cards.add(new Card(10, "Q", "♥"));
        cards.add(new Card(10, "K", "♥"));

        cards.add(new Card(1, "A", "♣"));
        cards.add(new Card(2, "2", "♣"));
        cards.add(new Card(3, "3", "♣"));
        cards.add(new Card(4, "4", "♣"));
        cards.add(new Card(5, "5", "♣"));
        cards.add(new Card(6, "6", "♣"));
        cards.add(new Card(7, "7", "♣"));
        cards.add(new Card(8, "8", "♣"));
        cards.add(new Card(9, "9", "♣"));
        cards.add(new Card(10, "10", "♣"));
        cards.add(new Card(10, "J", "♣"));
        cards.add(new Card(10, "Q", "♣"));
        cards.add(new Card(10, "K", "♣"));
    }

    //Barajar las cartas del mazo
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //Coger una carta y eliminarla del mazo
    public Card takeCard() {
        Card result = cards.get(0);
        cards.remove(0);
        return result;
    }
}
