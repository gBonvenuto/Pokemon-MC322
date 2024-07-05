package utils;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Jogador_Panel extends JPanel {
  private Jogador jogador;
  private JLabel pokemonAtual_label = new JLabel();
  private JLabel vidaAtual_label = new JLabel();
  private JLabel image_label = new JLabel();
  private JButton atacar_button = new JButton("Atacar");
  private JButton trocar_button = new JButton("Trocar de Pokemon");
  private JButton correr_button = new JButton("Correr");
  private JComboBox<String> ataques;

  private Pokemon pokemonAtual() {
    return jogador.getPokemonAtual();
  }

  public void update_ataques() {
    ataques = new JComboBox<String>(jogador.getPokemonAtual().getAtaquesString());
  }

  public void remove_buttons() {
    // TODO: REMOVER BOTÕES
  }

  public void update_image_label() {
    try {
      BufferedImage bulbassauro = ImageIO
          .read(new File("src/main/java/resources/" + jogador.getPokemonAtual().getNome() + ".png"));
      image_label.setIcon(new ImageIcon(getScaledImage(bulbassauro, 100, 100)));
      image_label.setPreferredSize(new Dimension(100, 100));
    } catch (IOException e) {
      System.err.println("Imagem não encontrada");
    }
  }

  public void update_pokemonAtual_label() {
    pokemonAtual_label = new JLabel("Pokemon: " + pokemonAtual().getNome());
  };

  public void update_vidaAtual_label() {
    vidaAtual_label.setText("Vida: " + pokemonAtual().getVida() + "/300");
  };

  public Jogador_Panel(Jogador jogador) {

    this.jogador = jogador;

    update_pokemonAtual_label();
    update_vidaAtual_label();
    update_ataques();
    update_image_label();

    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(gridbag);

    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridx = 0;
    add(new JLabel("Jogador: " + jogador.getName()));

    add(pokemonAtual_label, c);

    add(vidaAtual_label, c);

    add(image_label, c);

    c.gridwidth = GridBagConstraints.RELATIVE;
    add(ataques);
    c.gridwidth = GridBagConstraints.REMAINDER;
    add(atacar_button, c);

    add(trocar_button, c);
    add(correr_button, c);

    atacar_button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Jogo.setAtaque(jogador.getPokemonAtual().ataques.get(ataques.getSelectedIndex()));
        Jogo.setEscolha(1);
        Jogo.tick();

        updatePanels();
      }
    });

    trocar_button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Jogo.setEscolha(2);
      }
    });

    correr_button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Jogo.setEscolha(3);
      }
    });

  }

  private void updatePanels() {
    Batalha_Interface.jogador1_Panel.update_pokemonAtual_label();
    Batalha_Interface.jogador1_Panel.update_vidaAtual_label();
    Batalha_Interface.jogador1_Panel.update_ataques();
    Batalha_Interface.jogador1_Panel.update_image_label();
    remove(atacar_button);

    Batalha_Interface.jogador1_Panel.invalidate();
    Batalha_Interface.jogador1_Panel.validate();
    Batalha_Interface.jogador1_Panel.repaint();

    Batalha_Interface.jogador2_Panel.update_pokemonAtual_label();
    Batalha_Interface.jogador2_Panel.update_vidaAtual_label();
    Batalha_Interface.jogador2_Panel.update_ataques();
    Batalha_Interface.jogador2_Panel.update_image_label();

    System.out.println("Vida: "+vidaAtual_label.getText());

    Batalha_Interface.jogador2_Panel.invalidate();
    Batalha_Interface.jogador2_Panel.validate();
    Batalha_Interface.jogador2_Panel.repaint();

    Batalha_Interface.interface1.UpdatePanels();
  }

  private Image getScaledImage(Image srcImg, int w, int h) {
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
  }

}
