package blackjack;

import java.util.ArrayList;

public class Main {

    public static double suit; //масть карты
    public static double num; //номер карты в массиве
    public static ArrayList<Card> playerCards = new ArrayList<>();
    public static ArrayList<Card> dealerCards = new ArrayList<>();
    public static String[] cardochka = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"}; //номиналы карт

    public static int  bet = 0;

    public static int cash = 2000;
    public static Card[][] cards = new Card[4][13]; //массив с типом данных "Card"

    public static void main(String[] args) {
        new Window.window();

        for(int i = 0; i < 4; i++) //заполнение массива объектами "Card"
            for(int y = 0; y < 13; y++) {
                cards[i][y] = new Card();
            }

        Game.StartGame();
    }
}
