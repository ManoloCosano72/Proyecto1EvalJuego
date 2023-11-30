package Model;

import java.util.Objects;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit){
        this.value = value;
        this.suit= suit;
    }
    public Card(){
        this(0,"");
    }
    public int getValue(){
        return value;
    }
    public void setValue(){
        this.value=value;
    }
    public String getSuit(){
        return suit;
    }
    public void getValue(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Suit: "+suit+" Value: "+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }
}
