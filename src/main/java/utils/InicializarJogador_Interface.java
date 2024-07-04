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
  private JTextArea outputArea;
  private List<Pokemon> pokemonsEscolhidos;

  public Jogador jogador;

  public InicializarJogador_Interface() {
    setTitle("Seleção de Jogador");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Painel para o nome do jogador
    JPanel nomePanel = new JPanel();
    nomePanel.setLayout(new FlowLayout());
    nomePanel.add(new JLabel("Nome do jogador:"));
    nomeField = new JTextField(20);
    nomePanel.add(nomeField);

    // Painel para selecionar pokémons
    JPanel pokemonPanel = new JPanel();
    pokemonPanel.setLayout(new BorderLayout());
    pokemonPanel.setBorder(BorderFactory.createTitledBorder("Seleção de Pokémons"));

    outputArea = new JTextArea(10, 30);
    outputArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(outputArea);
    pokemonPanel.add(scrollPane, BorderLayout.CENTER);

    selecionarButton = new JButton("Selecionar Pokémons");
    pokemonPanel.add(selecionarButton, BorderLayout.SOUTH);

    // Adicionando componentes à janela principal
    add(nomePanel, BorderLayout.NORTH);
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
    Jogo.setJogador1(new Jogador(nomeField.toString(), pokemonsEscolhidos));
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
