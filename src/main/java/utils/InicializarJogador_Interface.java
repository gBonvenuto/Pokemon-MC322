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
    if (Jogo.getJogador1() == null)
      jogador = 1;
    else if (Jogo.getJogador2() == null)
      jogador = 2;

    if (jogador == 1)
      setTitle("Seleção do Jogador 1");
    else if (jogador == 2)
      setTitle("Seleção do Jogador 2");

    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    // Painel para o nome do jogador
    JPanel nomePanel = new JPanel();
    nomePanel.setLayout(new FlowLayout());
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
    selecionarButton = new JButton("Selecionar Pokémons");
    pokemonsSelecionadosPanel.add(selecionarButton, constraints);

    // Adicionando componentes à janela principal
    add(nomePanel, BorderLayout.NORTH);
    add(pokemonsSelecionadosPanel, BorderLayout.CENTER);

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

        pokemonsEscolhidos.add(Pokemon.pokemon.fromName((String) pokemon1.getSelectedItem()).inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.fromName((String) pokemon2.getSelectedItem()).inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.fromName((String) pokemon3.getSelectedItem()).inicializarPokemon());
        pokemonsEscolhidos.add(Pokemon.pokemon.fromName((String) pokemon4.getSelectedItem()).inicializarPokemon());

        // Se Tivermos selecionado o jogador1, vamos agora selecionar o jogador 2
        if (jogador == 1)
          InicializarJogador_Interface.main(new String[0]); // Inicializa o Jogador 2
        dispose();
        if (jogador == 2)
          System.out.println("Iniciando o jogo");

        // TODO: Lógica de selecionar os pokemons

      }
    });
    if (Jogo.getJogador1() == null)
      Jogo.setJogador1(new Jogador(nomeField.toString(), pokemonsEscolhidos));
    else if (Jogo.getJogador2() == null)
      Jogo.setJogador2(new Jogador(nomeField.toString(), pokemonsEscolhidos));
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
