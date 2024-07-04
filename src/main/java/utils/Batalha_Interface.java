package utils;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Batalha_Interface extends JFrame {
  private Icon pokemon1;
  private Icon pokemon2;
  Font fonte = new Font("serif", Font.PLAIN, 50);

  public Batalha_Interface() {

    JButton atacar = new JButton("Atacar");
    JButton passa = new JButton("Passa a vez");
    JButton troca = new JButton("Troca");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Batalha Pokemon");
    setSize(600, 400);
    setFont(fonte);
    setLayout(new BorderLayout());

    JPanel jogador1_Panel = jogador_Panel(Jogo.getJogador1());
    add(jogador1_Panel, BorderLayout.WEST);

    JPanel jogador2_Panel = jogador_Panel(Jogo.getJogador2());
    add(jogador2_Panel, BorderLayout.EAST);

  }

  private JPanel jogador_Panel(Jogador jogador){
    Pokemon pokemonAtual = jogador.getPokemonAtual();

    JPanel panel = new JPanel();
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    panel.setLayout(gridbag);

    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridx = 0;
    panel.add(new JLabel("Pokemon: "+pokemonAtual.getNome()), c);
    panel.add(new JLabel("Vida: "+pokemonAtual.getVida()+"/300"), c);
    try{
      BufferedImage bulbassauro = ImageIO.read(new File("src/main/java/resources/"+pokemonAtual.getNome()+".png"));
      JLabel image_label = new JLabel(new ImageIcon(getScaledImage(bulbassauro, 100, 100)));
      image_label.setPreferredSize(new Dimension(100,100));
      panel.add(image_label, c);
    }
    catch(IOException e){
      System.err.println("Imagem não encontrada");
    }

    JButton atacar_button = new JButton("Atacar");
    JButton trocar_button = new JButton("Trocar de Pokemon");
    JButton correr_button = new JButton("Correr");

    // Achar um jeito de arrumar isso aqui
    // JComboBox ataques = new JComboBox<String>(pokemonAtual.getAtaques());

    c.gridwidth = GridBagConstraints.RELATIVE;
    panel.add(atacar_button, c);
    c.gridwidth = GridBagConstraints.REMAINDER;
    // panel.add(ataques);

    panel.add(trocar_button, c);
    panel.add(correr_button, c);

    atacar_button.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // Jogo.setEscolha(1);
      }
    });

    return panel;
  }

  private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        Batalha_Interface interface1 = new Batalha_Interface();
        interface1.setVisible(true);
      }
    });
  }

}
