package utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogador {
  Scanner scanner = new Scanner(System.in);
  private String nome;
  private Pokemon.pokemon[] pokemons = new Pokemon.pokemon[4]; // Cada jogador terá somente 4 pokemons

  // Não é necessário passar parâmetros porque os valores de Jogador serão
  // definidor no stdin
  public Jogador() {
    System.out.println("Qual seu nome?");
    this.nome = scanner.nextLine();
    System.out.println("Agora vamos escolher seus pokemons:");
    SelecionarPokemons();
  }

  public void SelecionarPokemons() {
    boolean pokemon_valido = false;
    Pokemon.pokemon pokemon_escolhido;

    List<Ataque.ataques> todos_os_ataques = new ArrayList<Ataque.ataques>();

    for (Ataque.ataques ataque : Ataque.ataques.values()) {
      todos_os_ataques.add(ataque);
    }

    for (int i = 0; i < 4; i++) {
      pokemon_valido = false;
      Pokemon.pokemon.lista();

      do {
        System.out.println("Digite o nome do pokemon que você deseja escolher");
        pokemon_escolhido = Pokemon.pokemon.fromName(scanner.next());
        if (pokemon_escolhido != null) {
          pokemon_valido = true;
        } else {
          System.out.println("\nXX Não foi possível encontrar este pokemon, tente outro XX\n");
        }
      } while (!pokemon_valido);

      Random gerador = new Random();

      // Adicionando 4 ataques aleatórios ao pokemon
      for (int j = 0; j < 4; j++) {
        boolean ataque_valido = false;
        do {
          Ataque ataque = null;
          try {
            ataque = todos_os_ataques.get(gerador.nextInt(todos_os_ataques.size())).getAtaque()
                .getDeclaredConstructor().newInstance();
          } catch (Exception e) {
            System.err.println("Houve um erro ao processar os ataques do novo pokemon");
          }
          if (pokemon_escolhido.getTipos().contains(ataque.getTipo())) {
            pokemon_escolhido.addAtaque(ataque.getClass());
            ataque_valido = true;
          }
        } while (!ataque_valido);
      }

      pokemons[i] = pokemon_escolhido;
    }
  }

  @Override
  public String toString() {
    String pokemons_string = "\n";

    for (Pokemon.pokemon pokemon : pokemons) {
      String ataques_string = "Ataques: (";

      for (Class<? extends Ataque> ataque_class : pokemon.getAtaques()) {
        Ataque ataque = null;
        try {
          ataque = ataque_class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
          System.err.println("Não foi possível encontrar o ataque que o pokemon possui");
        }
        ataques_string += ataque.getNome() + ", ";
      }
      ataques_string += ")\n";

      pokemons_string = pokemons_string + "\t" + pokemon.getName() + " " + pokemon.getTipos() + ataques_string + "\n";
    }

    return String.format("""
        Nome: %s
        Pokemons: %s
        """,
        nome, pokemons_string);
  }

}
