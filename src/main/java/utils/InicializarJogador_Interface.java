package utils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InicializarJogador_Interface extends JFrame {

  private JTextField nomeField;
  private JButton selecionarButton;

  private JComboBox<String> pokemon1;
  private JComboBox<String> pokemon2;
  private JComboBox<String> pokemon3;
  private JComboBox<String> pokemon4;

  private List<Pokemon> pokemonsEscolhidos;

  private int jogador = 0;

  public InicializarJogador_Interface() {

    UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("TextArea.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("CheckBox.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("RadioButton.font", new Font("Arial", Font.PLAIN, 24));
    UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 24));

    if (Jogo.getJogador1() == null)
      jogador = 1;
    else if (Jogo.getJogador2() == null)
      jogador = 2;

    if (jogador == 1)
      setTitle("Seleção do Jogador 1");
    else if (jogador == 2)
      setTitle("Seleção do Jogador 2");

    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    // Painel para o nome do jogador
    JPanel nomePanel = new JPanel();
    if (jogador == 1)
      nomePanel.add(new JLabel("Nome do jogador 1:"));
    if (jogador == 2)
      nomePanel.add(new JLabel("Nome do jogador 2:"));
    nomeField = new JTextField(20);
    nomePanel.add(nomeField);

    // Pokemons selecionados
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    JPanel pokemonsSelecionadosPanel = new JPanel();
    pokemonsSelecionadosPanel.setLayout(gridbag);

    pokemon1 = new JComboBox<String>(Pokemon.pokemon.lista());
    pokemonsSelecionadosPanel.add(new JLabel("Pokemon 1: "), constraints);

    constraints.fill = GridBagConstraints.CENTER;
    constraints.gridwidth = GridBagConstraints.REMAINDER;
    pokemonsSelecionadosPanel.add(pokemon1, constraints);

    constraints.weightx = 1.0;
    constraints.gridwidth = GridBagConstraints.RELATIVE;
    pokemon2 = new JComboBox<String>(Pokemon.pokemon.lista());
    pokemonsSelecionadosPanel.add(new JLabel("Pokemon 2: "), constraints);

    constraints.gridwidth = GridBagConstraints.REMAINDER;
    pokemonsSelecionadosPanel.add(pokemon2, constraints);

    constraints.weightx = 1.0;
    constraints.gridwidth = GridBagConstraints.RELATIVE;
    pokemon3 = new JComboBox<String>(Pokemon.pokemon.lista());
    pokemonsSelecionadosPanel.add(new JLabel("Pokemon 3: "), constraints);

    constraints.gridwidth = GridBagConstraints.REMAINDER;
    pokemonsSelecionadosPanel.add(pokemon3, constraints);

    constraints.weightx = 1.0;
    constraints.gridwidth = GridBagConstraints.RELATIVE;
    pokemon4 = new JComboBox<String>(Pokemon.pokemon.lista());
    pokemonsSelecionadosPanel.add(new JLabel("Pokemon 4: "), constraints);

    constraints.gridwidth = GridBagConstraints.REMAINDER;
    pokemonsSelecionadosPanel.add(pokemon4, constraints);

    constraints.weightx = 0.0;
    constraints.anchor = GridBagConstraints.SOUTH;

    JPanel selecionarPanel = new JPanel();
    selecionarPanel.setLayout(new FlowLayout());

    selecionarButton = new JButton("Selecionar Pokémons");
    selecionarPanel.add(selecionarButton, constraints);

    // Adicionando componentes à janela principal
    add(nomePanel, BorderLayout.NORTH);
    add(pokemonsSelecionadosPanel, BorderLayout.CENTER);
    add(selecionarPanel, BorderLayout.SOUTH);

    // Inicialização dos pokémons escolhidos
    pokemonsEscolhidos = new ArrayList<>();

    // Ação do botão de selecionar pokémons
    selecionarButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        String nomeJogador = nomeField.getText();

        if (nomeJogador.isEmpty()) {
          JOptionPane.showMessageDialog(InicializarJogador_Interface.this,
              "Por favor, insira o nome do jogador.", "Erro", JOptionPane.ERROR_MESSAGE);
          return;
        }

        pokemonsEscolhidos.add(Pokemon.pokemon.values()[pokemon1.getSelectedIndex()].inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.values()[pokemon2.getSelectedIndex()].inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.values()[pokemon3.getSelectedIndex()].inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.values()[pokemon4.getSelectedIndex()].inicializarPokemon());

        // Caso haja pokemons repetidos

        // pokemon2
        if (pokemon2.getSelectedIndex() == pokemon1.getSelectedIndex())
          pokemonsEscolhidos.get(1).setNome(pokemonsEscolhidos.get(1).getNome() + " 2");

        // pokemon3
        int pokemon_i = 1;
        if (pokemon3.getSelectedIndex() == pokemon1.getSelectedIndex())
          pokemon_i++;
        if (pokemon3.getSelectedIndex() == pokemon2.getSelectedIndex())
          pokemon_i++;
        if (pokemon_i > 1)
          pokemonsEscolhidos.get(2).setNome(pokemonsEscolhidos.get(2).getNome() + " " + pokemon_i);

        // pokemon4
        pokemon_i = 1;
        if (pokemon4.getSelectedIndex() == pokemon1.getSelectedIndex())
          pokemon_i++;
        if (pokemon4.getSelectedIndex() == pokemon2.getSelectedIndex())
          pokemon_i++;
        if (pokemon4.getSelectedIndex() == pokemon3.getSelectedIndex())
          pokemon_i++;
        if (pokemon_i > 1)
          pokemonsEscolhidos.get(3).setNome(pokemonsEscolhidos.get(3).getNome() + " " + pokemon_i);

        // Se Tivermos selecionado o jogador1, vamos agora selecionar o jogador 2
        if (jogador == 1) {
          InicializarJogador_Interface.main(new String[0]); // Inicializa o Jogador 2
          Jogo.setJogador1(new Jogador(nomeField.getText(), pokemonsEscolhidos));
          System.out.println("Jogador1: " + Jogo.getJogador1().getName());
        }
        if (jogador == 2) {
          System.out.println("Iniciando o jogo");
          Jogo.setJogador2(new Jogador(nomeField.getText(), pokemonsEscolhidos));
          Batalha_Interface.main(new String[0]);
          Jogo.logicaJogo();
        }

        dispose();
      }
    });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        InicializarJogador_Interface interface1 = new InicializarJogador_Interface();
        interface1.setVisible(true);
      }
    });
  }
}
