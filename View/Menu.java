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
        System.out.println(
                "   ____          _        ____   _______      ___   ____               ___                ___       ___       _      ___      ______      ___   ____    ____        ____    \n" +
                "  6MMMMb/       dM.      6MMMMb\\ `MM'`MM\\     `M'  6MMMMb              `MM                `MMb     dMM'      dM.     `MM\\     `M'`MM\\     `M'  6MMMMb   `MM'       6MMMMb   \n" +
                " 8P    YM      ,MMb     6M'    `  MM  MMM\\     M  8P    Y8              MM                 MMM.   ,PMM      ,MMb      MMM\\     M  MMM\\     M  8P    Y8   MM       8P    Y8  \n" +
                "6M      Y      d'YM.    MM        MM  M\\MM\\    M 6M      Mb         ____MM   ____          M`Mb   d'MM      d'YM.     M\\MM\\    M  M\\MM\\    M 6M      Mb  MM      6M      Mb \n" +
                "MM            ,P `Mb    YM.       MM  M \\MM\\   M MM      MM        6MMMMMM  6MMMMb         M YM. ,P MM     ,P `Mb     M \\MM\\   M  M \\MM\\   M MM      MM  MM      MM      MM \n" +
                "MM            d'  YM.    YMMMMb   MM  M  \\MM\\  M MM      MM       6M'  `MM 6M'  `Mb        M `Mb d' MM     d'  YM.    M  \\MM\\  M  M  \\MM\\  M MM      MM  MM      MM      MM \n" +
                "MM           ,P   `Mb        `Mb  MM  M   \\MM\\ M MM      MM       MM    MM MM    MM        M  YM.P  MM    ,P   `Mb    M   \\MM\\ M  M   \\MM\\ M MM      MM  MM      MM      MM \n" +
                "MM           d'    YM.        MM  MM  M    \\MM\\M MM      MM       MM    MM MMMMMMMM        M  `Mb'  MM    d'    YM.   M    \\MM\\M  M    \\MM\\M MM      MM  MM      MM      MM \n" +
                "YM      6   ,MMMMMMMMb        MM  MM  M     \\MMM YM      M9       MM    MM MM              M   YP   MM   ,MMMMMMMMb   M     \\MMM  M     \\MMM YM      M9  MM      YM      M9 \n" +
                " 8b    d9   d'      YM. L    ,M9  MM  M      \\MM  8b    d8        YM.  ,MM YM    d9        M   `'   MM   d'      YM.  M      \\MM  M      \\MM  8b    d8   MM    /  8b    d8  \n" +
                "  YMMMM9  _dM_     _dMM_MYMMMM9  _MM__M_      \\M   YMMMM9          YMMMMMM_ YMMMM9        _M_      _MM__dM_     _dMM__M_      \\M _M_      \\M   YMMMM9   _MMMMMMM   YMMMM9   \n" +
                "                                                                                                                                                                            ");
        System.out.println("Bienvenidos al CASINO de Manolo 🤑🤑🤑");
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
