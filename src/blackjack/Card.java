package blackjack;

public class Card {

    public String Image = cardImage();
    int points = cardPoints();

    public static String suitImg = "";
    public static String cardImage(){ //инициализация картинки карты
        switch((int) Main.suit) { //выбор масти по номеру в массиве
            case 0:
                suitImg = "♥";
                break;
            case 1:
                suitImg = "♦";
                break;
            case 2:
                suitImg = "♣";
                break;
            case 3:
                suitImg = "♠";
                break;
        }

        String image = "[" + Main.cardochka[(int) Main.num] + suitImg + "]"; //картинка карты

        return image;
    }

    public static int cardPoints() { //очки каждой карты
        int points = 0;

        if (Main.num > 8 && Main.num < 12)
            points = 10;
        else if(Main.num>12)
            points = 11;
        else
            points = (int) Main.num + 2;

        return points;
    }
}
