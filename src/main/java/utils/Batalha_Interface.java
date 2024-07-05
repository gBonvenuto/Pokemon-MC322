package utils;

import javax.swing.*;

import java.awt.*;

public class Batalha_Interface extends JFrame {
  public static Jogador_Panel jogador1_Panel;
  public static Jogador_Panel jogador2_Panel;
  public static Batalha_Interface interface1;
  private static JTextArea log = new JTextArea();

  public void UpdatePanels() {
    invalidate();
    validate();
    repaint();
  }

  public static void appendLog(String string) {
    log.append(string + "\n");
  }

  public Batalha_Interface() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Batalha Pokemon");
    setSize(1000, 500);
    setLayout(new BorderLayout());
    setLocationRelativeTo(null);

    jogador1_Panel = new Jogador_Panel(Jogo.getJogador1());
    add(jogador1_Panel, BorderLayout.WEST);

    jogador2_Panel = new Jogador_Panel(Jogo.getJogador2());
    add(jogador2_Panel, BorderLayout.EAST);

    log.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(log);
    scrollPane.setPreferredSize(new Dimension(100, 100));
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    add(scrollPane, BorderLayout.SOUTH);

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
