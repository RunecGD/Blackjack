package blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public static class  window extends JFrame {
        window() {
            ActionListener actionListener = new buttonPress();

            JButton b_pass = new JButton("Пас");
            b_pass.setBounds(0, 10, 100, 50);
            b_pass.addActionListener(actionListener);
            b_pass.setActionCommand("Пас");

            JButton b_take = new JButton("Взять карту"); //создание кнопки Взять карту
            b_take.setBounds(110, 10, 100, 50);
            b_take.addActionListener(actionListener);
            b_take.setActionCommand("Взять карту");

            JButton b_take_multiply= new JButton("Ставка х2"); //создание кнопки Ставка х2
            b_take_multiply.setBounds(220, 10, 100, 50);
            b_take_multiply.addActionListener(actionListener);
            b_take_multiply.setActionCommand("Ставка х2");

            JButton b_end = new JButton("Вскрыться"); //создание кнопки Вскрыться
            b_end.setBounds(330, 10, 100, 50);
            b_end.addActionListener(actionListener);
            b_end.setActionCommand("Вскрыться");

            setTitle("Blackjack"); //создание экрана с кнопами
            getContentPane().setBackground(Color.WHITE);
            setLocationRelativeTo(null);
            add(b_pass);
            add(b_take);
            add(b_take_multiply);
            add(b_end);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(445, 100);
            setLayout(null);
            setVisible(true);
        }
    }

    public static class buttonPress implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Game.action = e.getActionCommand();
            System.out.println("<" + Game.action + ">" + "\n");

            if(Game.action=="Взять карту"){
                Game.Take();
            }
            else if(Game.action == "Пас"){
                Main.cash=Main.cash-(Main.bet/2);
                Game.StartGame();
            }
            else if(Game.action=="Вскрыться"){
                Game.ShowCards();
                Game.StartGame();
            }
            else if(Game.action=="Ставка х2"){
                Main.bet = Main.bet * 2;
                Game.Take();
            }
        }
    }
}


