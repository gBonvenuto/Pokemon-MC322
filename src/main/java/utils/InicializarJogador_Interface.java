package utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InicializarJogador_Interface extends JFrame {

  private JTextField nomeField;
  private JButton selecionarButton;
  private JTextArea outputArea;
  private JList listaPokemons;
  private List<Pokemon> pokemonsEscolhidos;

  private int jogador = 0;

  public InicializarJogador_Interface() {
    if(Jogo.getJogador1() == null)
      jogador = 1;
    else if(Jogo.getJogador2() == null)
      jogador = 2;

    if(jogador == 1)
      setTitle("Seleção do Jogador 1");
    else if(jogador == 2)
      setTitle("Seleção do Jogador 2");

    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Painel para o nome do jogador
    JPanel nomePanel = new JPanel();
    nomePanel.setLayout(new FlowLayout());
    if(jogador==1)
      nomePanel.add(new JLabel("Nome do jogador 1:"));
    if(jogador==2)
      nomePanel.add(new JLabel("Nome do jogador 2:"));
    nomeField = new JTextField(20);
    nomePanel.add(nomeField);

    // Pokemons selecionados
    JPanel pokemonsSelecionadosPanel = new JPanel();
    pokemonsSelecionadosPanel.setLayout(new BorderLayout());
    pokemonsSelecionadosPanel.add(new JLabel("Pokemon 1:"));
    pokemonsSelecionadosPanel.add(new JLabel("\nPokemon 2:"));
    pokemonsSelecionadosPanel.add(new JLabel("\nPokemon 3:"));
    pokemonsSelecionadosPanel.add(new JLabel("\nPokemon 4:"));

    // Painel para selecionar pokémons
    JPanel pokemonPanel = new JPanel();
    pokemonPanel.setLayout(new BorderLayout());
    pokemonPanel.setBorder(BorderFactory.createTitledBorder("Seleção de Pokémons"));

    listaPokemons = new JList<String>(Pokemon.pokemon.lista());
    pokemonPanel.add(listaPokemons, BorderLayout.CENTER);

    selecionarButton = new JButton("Selecionar Pokémons");
    pokemonPanel.add(selecionarButton, BorderLayout.SOUTH);

    // Adicionando componentes à janela principal
    add(nomePanel, BorderLayout.NORTH);
    add(pokemonsSelecionadosPanel, BorderLayout.EAST);
    add(pokemonPanel, BorderLayout.CENTER);

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

        outputArea.setText(""); // Limpa o texto anterior

        for (int i = 0; i < 4; i++) {
          boolean pokemonValido = false;
          Pokemon pokemonEscolhido = null;

          while (!pokemonValido) {
            String nomePokemon = JOptionPane.showInputDialog(InicializarJogador_Interface.this,
                "Digite o nome do pokemon que você deseja escolher:");
            if (nomePokemon == null) { // Usuário cancelou
              return;
            }

            pokemonEscolhido = Pokemon.pokemon.fromName(nomePokemon).inicializarPokemon();

            if (pokemonEscolhido != null) {
              pokemonValido = true;
            } else {
              JOptionPane.showMessageDialog(InicializarJogador_Interface.this,
                  "Não foi possível encontrar este pokemon, tente outro.",
                  "Erro", JOptionPane.ERROR_MESSAGE);
            }
          }

          pokemonsEscolhidos.add(pokemonEscolhido);
          outputArea.append("Pokemon escolhido: " + pokemonEscolhido.getNome() + "\n");

        }

        outputArea.append("\nJogador: " + nomeJogador + "\n");
      }
    });
    if(Jogo.getJogador1() == null)
      Jogo.setJogador1(new Jogador(nomeField.toString(), pokemonsEscolhidos));
    else if(Jogo.getJogador2() == null)
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
