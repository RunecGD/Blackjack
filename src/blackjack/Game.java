package blackjack;

import java.util.Scanner;

public class Game {

    public static int playerPoints = 0;

    public static int dealerPoints = 0;
    public static boolean isDealer = true;

    public static String action = "";

    public static void StartGame() {
        Main.playerCards.clear();
        Main.dealerCards.clear();
        playerPoints = 0;
        dealerPoints = 0;
        isDealer = true;
        Main.bet = 0;
        Bet_Player();

        int numb = 2;

        initCards(numb);
        System.out.println("Рука дилера:");
        System.out.print(Main.dealerCards.get(0).Image + " [X] " + "\n");
        dealerPoints = Main.dealerCards.get(0).points + Main.dealerCards.get(1).points;

        isDealer = false;
        initCards(numb);
        System.out.println("Твоя рука:");
        for (int i = 0; i < Main.playerCards.size(); i++) {
            System.out.print(Main.playerCards.get(i).Image + " ");
        }

        System.out.println(" Деньги: " + "$" + Main.cash + " Ставка: " + "$" + Main.bet + "\n");
    }

    public static void initCards(int number) { //инициализация карты
        int i = 0;
        while(i < number) { //количество инициализированных карт

            Main.suit = Math.random() * 4; //случайная масть
            Main.num = Math.random() * 13; //случайная карта

            Main.cards[(int) Main.suit][(int) Main.num].Image = Card.cardImage();
            Main.cards[(int) Main.suit][(int) Main.num].points = Card.cardPoints();

            if(isDealer)
                Main.dealerCards.add(Main.cards[(int) Main.suit][(int) Main.num]);
            else {
                Main.playerCards.add(Main.cards[(int) Main.suit][(int) Main.num]);
                playerPoints = playerPoints + Main.cards[(int) Main.suit][(int) Main.num].points;
            }

            i++;
        }
    }

    public static void Take(){
        Main.suit = Math.random() * 4; //случайная масть
        Main.num = Math.random() * 13; //случайная карта

        Main.cards[(int) Main.suit][(int) Main.num].Image = Card.cardImage();
        Main.cards[(int) Main.suit][(int) Main.num].points = Card.cardPoints();

        Main.playerCards.add(Main.cards[(int) Main.suit][(int) Main.num]);

        Game.playerPoints = Game.playerPoints + Main.cards[(int) Main.suit][(int) Main.num].points;

        if(Main.num>12 && playerPoints > 21)
            Game.playerPoints = Game.playerPoints - 10;

        System.out.println("Рука дилера:");
        System.out.print(Main.dealerCards.get(0).Image + " [X] ");

        System.out.println("Твоя рука:");
        for (int i = 0; i < Main.playerCards.size(); i++) {
            System.out.print(Main.playerCards.get(i).Image + " ");
        }
        System.out.println(" Деньги: " + "$" + Main.cash + " Ставка: " + "$" + Main.bet + "\n");
    }

    public static void ShowCards(){
        while(dealerPoints < 17) { //количество инициализированных карт

            Main.suit = Math.random() * 4; //случайная масть
            Main.num = Math.random() * 13; //случайная карта

            Main.cards[(int) Main.suit][(int) Main.num].Image = Card.cardImage();
            Main.cards[(int) Main.suit][(int) Main.num].points = Card.cardPoints();


            Main.dealerCards.add(Main.cards[(int) Main.suit][(int) Main.num]);

            dealerPoints = dealerPoints + Main.cards[(int) Main.suit][(int) Main.num].points;
        }


        if(dealerPoints<playerPoints && playerPoints<=21){
            System.out.println("Вы выиграли!!");
            Main.cash=Main.cash+Main.bet;
        }
        else{
            System.out.println("Вы проиграли!!");
            Main.cash=Main.cash-Main.bet;
        }

        System.out.println("Рука дилера:");
        for (int i = 0; i < Main.dealerCards.size(); i++) {
            System.out.print(Main.dealerCards.get(i).Image + " ");
        }
        System.out.println(" Очки дилера: " + dealerPoints + "\n");

        System.out.println("Твоя рука: ");
        for (int i = 0; i < Main.playerCards.size(); i++) {
            System.out.print(Main.playerCards.get(i).Image + " ");
        }
        System.out.println(" Твои очки: " + playerPoints + "\n");
    }
    public static void Bet_Player(){
        System.out.print("Деньги: " + Main.cash + "\n");

        System.out.print("Введите ставку: ");
        Scanner scan = new Scanner(System.in);
        Main.bet = scan.nextInt();
        if(Main.bet > Main.cash) {
            System.out.println("Недостаточно денег");
            StartGame();
        } else if (Main.bet < 400) {
            System.out.println("Минимальная ставка — 400");
            StartGame();
        }
    }
}

