package Model;

public class Card {
    private int value;
    private String display;
    private String suit;

    //
    public Card(int value, String display, String suit) {
        this.value = value;
        this.display = display;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    //El diseño de la carta que se imprimira por pantalla al jugar
    @Override
    public String toString() {
        return "  ╔════════╗\n"
                + "  ║ " + display + "      ║\n"
                + "  ║        ║\n"
                + "  ║   " + suit + "    ║\n"
                + "  ║        ║\n"
                + "  ║      " + display + " ║\n"
                + "  ╚════════╝";

    }
}
