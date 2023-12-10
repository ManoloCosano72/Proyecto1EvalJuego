package Model;

public class Card {
    private int value;
    private String display;
    private String suit;


    public Card(int value, String display, String suit) {
        this.value = value;
        this.display = display;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
            return "╔════════╗\n" +
                    "║ " + value + "      ║\n" +
                    "║        ║\n" +
                    "║   " + suit + "    ║\n" +
                    "║        ║\n" +
                    "║      " + value + " ║\n" +
                    "╚════════╝";
        }

    /*@Override
    public String toString() {
        return "Suit: " + suit + " Value: " + value;
    }
    */

    /*@Override
    public boolean equals(Objects o) {
        if (this == 0) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }
    */
    }
