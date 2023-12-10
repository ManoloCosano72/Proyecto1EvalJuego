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
    private int score;

    public Game() {
        players = new ArrayList<Player>();
        deck = new Deck();
        currentPlayer = 0;
    }

    public void init() {
        Menu.printWelcomeMessage();
        System.out.println("************************************************");
        Menu.printRules();
        System.out.println("************************************************");
        initPlayers();
        play();
    }

    private void initPlayers() {
        Menu.printNumPlayers();
        int n = 0;
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Menu.playerName();
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            this.players.add(new Player(name));
        }
        if (n == 1) {
            this.players.add(new Player("IA"));
        }
    }

    private void play() {
        //1-Barajar las cartas del mazo
        this.deck.shuffle();

        //2-Los jugadores reciben dos cartas iniciales
        for (int i = 0; i < players.size(); i++) {
            this.players.get(i).addCard(this.deck.takeCard());
            this.players.get(i).addCard(this.deck.takeCard());
        }

        //3-Turnos de los jugadores (cada uno)
        for (int i = 0; i < players.size(); i++) {
            System.out.println("***************************************************");

            //Si jugamos con la IA
            if (players.get(i).getName().equals("IA")) {

                //La IA tiene que saber la puntuacion del jugador
                int playerScore = calculateScore(players.get(i - 1));
                Menu.printCurrentState(players.get(i),calculateScore(players.get(i)));

                //Si el jugador no se ha pasado
                if (playerScore <= 21) {

                    //La IA coge cartas hasta superar al jugador o se pase de 21
                    while (calculateScore(players.get(i)) <= playerScore && calculateScore(players.get(i)) <= 21) {
                        this.players.get(i).addCard(this.deck.takeCard());
                        Menu.printCurrentState(players.get(i),calculateScore(players.get(i)));
                    }
                }
            } else {
                int playerScore = calculateScore(this.players.get(i));
                if (playerScore > 21) {
                    Menu.printCurrentState(this.players.get(i), playerScore);
                } else {
                    boolean exitLoop = false;
                    do {
                        Menu.printCurrentState(this.players.get(i), playerScore);
                        System.out.println("1- Sacar una carta");
                        System.out.println("2- Plantarse");
                        int option = 0;
                        option = scanner.nextInt();
                        if (option == 1) {
                            this.players.get(i).addCard(this.deck.takeCard());
                            playerScore = calculateScore(this.players.get(i));
                        }
                        exitLoop = playerScore > 21 || option == 2;
                    } while (!exitLoop);
                    if (playerScore > 21) {
                        Menu.printCurrentState(this.players.get(i), playerScore);
                    }
                }
            }
        }

        //4-Decir que jugador ha ganado de todos
        System.out.println("***************************************************");
        int winnerIndex = checkWinnerPlayer();
        if (winnerIndex == -1) {
            System.out.println("Todos los jugadores han perdido");
        } else {
            System.out.println("El jugador " + players.get(winnerIndex).getName() + " ha ganado el juego!!!");
        }
    }

    private int calculateScore(Player p) {
        int score = 0;
        for (int i = 0; i < p.getCards().size(); i++) {
            int add = p.getCards().get(i).getValue();
            //Comprobacion del as si vale 1 u 11
            if (add == 1 && score + 11 <= 21) {
                add = 11;
            }
            score += add;
        }
        return score;
    }

    private int checkWinnerPlayer() {
        //tenemos que buscar el jugador con la puntuacion mas alta sin pasarse de 21
        //Si todos los jugadores pierden sale -1
        int max = -1;
        int idex = -1;
        for (int i = 0; i < players.size(); i++) {
            int score = calculateScore(players.get(i));
            score = score > 21 ? -1 : score;
            if (score > max) {
                max = score;
                idex = i;
            }
        }

        return idex;
    }
}

