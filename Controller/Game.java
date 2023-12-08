package Controller;

import java.util.ArrayList;

import Model.Deck;
import Model.Player;
import View.Menu;

import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private List<Player> players;
    private Deck deck;
    private int currentPlayer;

    public Game() {
        players = new ArrayList<Player>();
        deck = new Deck();
        currentPlayer = 0;
    }

    public void init() {
        initPlayers();
        play();
    }

    private void initPlayers() {
        Menu.printNumPlayers();
        int n = 0;
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = "";
            this.players.add(new Player(name));
        }
        if (n==1) {
            this.players.add(new Player("IA"));
        }
    }

    private void play() {
        this.deck.shuffle();
        for (int i = 0; i < players.size(); i++) {
            this.players.get(i).addCard(this.deck.takeCard());
            this.players.get(i).addCard(this.deck.takeCard());
        }
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals("IA")){
                //logica de cuando juega la IA
            } else{
                int playerScore = calculateScore(this.players.get(i));
                if (playerScore > 21) {
                    Menu.printCurrentState(this.players.get(i), playerScore);
                } else {
                    boolean exitLoop = false;
                    do {
                        Menu.printCurrentState(this.players.get(i), playerScore);
                        System.out.println("1. Sacar una carta");
                        System.out.println("2. Plantarse");
                        int option = 0;
                        option = scanner.nextInt();
                        if (option == 1) {
                            this.players.get(i).addCard(this.deck.takeCard());
                            playerScore = calculateScore(this.players.get(i));
                        }
                        exitLoop = playerScore > 21 || option == 2;
                    } while (!exitLoop);
                }
            }

        }
    }

    private int calculateScore(Player p) {
        //pendiente hacer calcular la puntuacion
        return 0;
    }
    //comprobar quien ha ganado de los jugadores
}

