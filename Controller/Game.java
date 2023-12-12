package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import Model.Deck;
import Model.Player;
import View.Menu;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private List<Player> players;
    private Deck deck;


    public Game() {
        players = new ArrayList<Player>();
        deck = new Deck();

    }

    //Funcion para mostrar los mensajes de menu y inciar el juego y los jugadores
    public void init() {
        System.out.println("***********************************************");
        Menu.printWelcomeMessage();
        System.out.println("*****************************************************************************");
        Menu.printRules();
        System.out.println("******************************************************************************");
        initPlayers();
        play();
    }

    //Funcion para indicar los jugadores que van a jugar y mostrarlos por pantalla
    private void initPlayers() {
        Menu.printNumPlayers();

        //Aqui se indica los jugadores que van a jugar
        int nPlayer = 0;

        //Aqui esta el control de errores que nos dira que valores no son validos para poder jugar
        do {
            try {
                nPlayer = scanner.nextInt();
                if (nPlayer < 1 || nPlayer > 4) {
                    System.out.println("Error en numero de jugadores, debe de ser entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduzca un valor valido");
                scanner.nextLine();
            }

        } while (nPlayer < 1 || nPlayer > 4);
        for (int i = 0; i < nPlayer; i++) {
            String playerName;
            boolean nameValid = false;
            Menu.playerName();

            //Control de errores de los nombres, si ponemos algunos de los valores no permitidos no podremos continuar
            do {
                scanner = new Scanner(System.in);
                playerName = scanner.nextLine().trim();
                nameValid=true;

                if (playerName.equalsIgnoreCase("IA")) {
                    nameValid = false;
                    System.out.println("Error de nombre, no puedes llamarte 'IA', escribe de nuevo: ");
                } else if (playerName.isEmpty() || playerName.isBlank()) {
                    nameValid = false;
                    System.out.println("Error de nombre, no puedes escribir el nombre vacío o solo espacios, escribe de nuevo: ");
                } else {
                    for (int j=0;j<players.size();j++){
                        if(players.get(j).getName().equalsIgnoreCase(playerName)){
                            System.out.println("Error de nombre, no puedes llamarte igual que otro jugador registrado. Escribe de nuevo: ");
                            nameValid= false;
                            break;
                        }
                    }
                }
            } while (!nameValid);
            this.players.add(new Player(playerName));
        }
        //Se ejecuta cuando solo jugamos contra la IA, se añade la IA como jugador
        if (nPlayer == 1) {
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
                int playerScore = calculateScore(players.get(i-1));
                Menu.printCurrentState(players.get(i), calculateScore(players.get(i)));

                //Si el jugador no se ha pasado
                if (playerScore <= 21) {

                    //La IA coge cartas hasta superar al jugador o se pase de 21
                    while (calculateScore(players.get(i)) <= playerScore && calculateScore(players.get(i)) <= 21) {
                        this.players.get(i).addCard(this.deck.takeCard());
                        Menu.printCurrentState(players.get(i), calculateScore(players.get(i)));
                    }
                }
                //Si jugamos contra otro jugador
            } else {
                int playerScore = calculateScore(this.players.get(i));
                if (playerScore > 21) {
                    Menu.printCurrentState(this.players.get(i), playerScore);
                } else {
                    boolean exitLoop = false;
                    do {
                        Menu.printCurrentState(this.players.get(i), playerScore);
                        System.out.println("Elige una opcion: ");
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
        List<Player> winners= checkWinnerPlayer();
        Menu.printWinnerPlayer(winners);
    }

    //Funcion para calcular la puntuacion del jugador
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

    //Funcion que comprueba quien ha ganado
    private List<Player> checkWinnerPlayer() {
        //tenemos que buscar el jugador con la puntuacion mas alta sin pasarse de 21
        //Si todos los jugadores pierden sale -1
        List<Player> result = new ArrayList<Player>();
        int max = -1;
        for (int i = 0; i < players.size(); i++) {
            int score = calculateScore(players.get(i));
            score = score > 21 ? -1 : score;
            if (score > max) {
                result.clear();
                max = score;
                result.add(players.get(i));
                //Comprobar si hay empate
            } else if (score ==max && max > -1) {
                result.add(players.get(i));
            }
        }
        return result;
    }
}


