package utils;

import javax.swing.*;

import java.awt.*;

public class Batalha_Interface extends JFrame {
  public static Jogador_Panel jogador1_Panel;
  public static Jogador_Panel jogador2_Panel;
  public static Batalha_Interface interface1;

  public void UpdatePanels(){
    invalidate();
    validate();
    repaint();
  }

  public Batalha_Interface() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Batalha Pokemon");
    setSize(600, 400);
    setLayout(new BorderLayout());

    jogador1_Panel = new Jogador_Panel(Jogo.getJogador1());
    add(jogador1_Panel, BorderLayout.WEST);

    jogador2_Panel = new Jogador_Panel(Jogo.getJogador2());
    add(jogador2_Panel, BorderLayout.EAST);

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        interface1 = new Batalha_Interface();
        interface1.setVisible(true);
      }
    });
  }

}
