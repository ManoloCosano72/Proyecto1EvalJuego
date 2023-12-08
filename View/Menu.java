package View;

import Model.Player;

public class Menu {
    public static void printCurrentState(Player p, int score){
        System.out.println(p.getName());
    }

    public static void printNumPlayers(){
        System.out.println("Di la cantidad de jugadores que van a jugar (1 para jugar con la IA)");
    }
}
