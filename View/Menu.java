package View;

import Model.Player;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Menu menu = new Menu();
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    //Funcion que mostrara el mensaje de bienvenida al inciar
    public static void printWelcomeMessage() {
        System.out.println("Bienvenidos al casino de Manolo 🤑🤑🤑");
    }

    //Funcion que muestra las reglas del juego
    public static void printRules() {
        System.out.println("Las reglas del juego son las siguientes: ");
        System.out.println("-Cada jugador comienza con 2 cartas");
        System.out.println("-Pueden sacar una carta hasta que se planten o superen 21 puntos en total");
        System.out.println("-El ganador es el que se acerque mas a 21 sin superarlo");
        System.out.println("-Las cartas J, Q y K valen 10 mientras que el As vale 1 u 11 segun lo que sea mas beneficioso para el jugador al momento de sacar carta");
    }

    //Funcion que nos muestra el mensaje para indicar los jugadores
    public static void printNumPlayers() {
        System.out.println("Di la cantidad de jugadores que van a jugar (1-4, 1 para jugar contra la IA): ");
    }

    //Funcion que nos dice que escribamos nuestro nombre
    public static void playerName() {
        System.out.println("Escriba su nombre: ");
    }

    //Funcion que nos dice la puntuacion actual del jugador
    public static void printCurrentState(Player p, int score) {
        System.out.println("Jugador: " + p.getName());
        System.out.println("Puntuacion total: " + score);
        for (int i = 0; i < p.getCards().size(); i++) {
            System.out.println(p.getCards().get(i).toString());
        }
        if (score > 21) {
            System.out.println("Te has pasado, ya la has cagado");
        }
    }

    //Funcion que nos indica quien de los jugadores ha ganado
    public static void printWinnerPlayer(List<Player> p) {
        if (p == null || p.isEmpty()) {
            System.out.println("Todos habeis perdido");
        }else if(p.size() >1){
            System.out.println("Ha habido un empate");
        }else {
            for (int i =0; i<p.size();i++){
            System.out.println("La maquina de " +p.get(i).getName()+ " ha ganado el juego 😎😎");
            }
        }
    }
}
