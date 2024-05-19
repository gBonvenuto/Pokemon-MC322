package utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// TODO: Devido ao tempo não foi possível implementar o servidor, e por isso
// ainda não implementamos a sobrecarga de métodos na classe Jogador
//
// Como o jogo será multiplayer, instanciaremos 2 jogadores e faremos 
// sobrecarga de métodos dependendo se é o jogador local ou o externo
// Ao finalizar o servidor começar a montar a parte do jogador externo
public class Jogador {

  Scanner scanner = new Scanner(System.in);
  private String nome;
  private Pokemon[] pokemons = new Pokemon[4]; // Cada jogador terá somente 4 pokemons

  // Não é necessário passar parâmetros porque os valores de Jogador serão
  // definidos no stdin
  public Jogador() {
    System.out.println("Qual seu nome?");
    this.nome = scanner.nextLine();
    System.out.println("Agora vamos escolher seus pokemons:");
    SelecionarPokemons();
  }

  // Esta função mostra o nome dos pokemons que podemo ser escolhidos até o
  // momento e permite que o jogador selecione dentre eles
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

      // Repetimos este passo até que o jogador escolha um poquemon válido
      do {
        System.out.println("Digite o nome do pokemon que você deseja escolher");
        pokemon_escolhido = Pokemon.pokemon.fromName(scanner.next());
        if (pokemon_escolhido != null) {
          pokemon_valido = true;
        } else {
          System.out.println("\nXX Não foi possível encontrar este pokemon, tente outro XX\n");
        }
      } while (!pokemon_valido);
      pokemons[i] = new Pokemon(pokemon_escolhido.getName(), pokemon_escolhido.getTipos(),
          null); // TODO: Os ataques serão definidos de forma aleatória na parte 2
    }
  }

  // Função que permite imprimir todas as informações do jogador (para debugging)
  @Override
  public String toString() {
    String pokemons_string = "\n";

    for (Pokemon pokemon : pokemons) {

      pokemons_string = pokemons_string + "\t" + pokemon.getNome() + " (" + pokemon.getVida() + ") " + pokemon.getTipo()
          + "\n";
    }

    return String.format("""
        Nome: %s
        Pokemons: %s
        """,
        nome, pokemons_string);
  }

}
