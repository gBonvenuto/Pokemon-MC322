package utils;
import java.util.Scanner;

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

    for (int i = 0; i < pokemons.length; i++) {
      pokemon_valido = false;
      System.out.println(Pokemon.pokemon.values());

      do {
        System.out.println("Digite o nome do pokemon que você deseja escolher");
        pokemon_escolhido = Pokemon.pokemon.fromName(scanner.next());
        if (pokemon_escolhido != null) {
          pokemon_valido = true;
        } else {
          System.out.println("Não foi possível encontrar este pokemon, tente outro");
        }
      } while (pokemon_valido);

      pokemons[i] = pokemon_escolhido;
    }
  }

  @Override
  public String toString(){
    return String.format("""
        Nome: {0}
Pokemons: {1}
        """,
        nome, pokemons);
  }

}
