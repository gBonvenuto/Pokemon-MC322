package utils;

import java.util.Scanner;

import utils.Pokemon.pokemon;

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
  private List<Pokemon> pokemons; // Cada jogador terá somente 4 pokemons
  private int pokemon_atual = 0;

  // Não é necessário passar parâmetros porque os valores de Jogador serão
  // definidos no stdin
  public Jogador(String nome,  List<Pokemon> pokemons) {
    this.nome = nome;
    this.pokemons = pokemons;
  }

  // Esta função mostra o nome dos pokemons que podemo ser escolhidos até o
  // momento e permite que o jogador selecione dentre eles
  // public void SelecionarPokemons() {
  //   boolean pokemon_valido = false;
  //   Pokemon.pokemon pokemon_escolhido;
  //
  //   List<Ataque.ataques> todos_os_ataques = new ArrayList<Ataque.ataques>();
  //
  //   for (Ataque.ataques ataque : Ataque.ataques.values()) {
  //     todos_os_ataques.add(ataque);
  //   }
  //
  //   for (int i = 0; i < 4; i++) {
  //     pokemon_valido = false;
  //     Pokemon.pokemon.lista();
  //
  //     // Repetimos este passo até que o jogador escolha um poquemon válido
  //     do {
  //       System.out.println("Digite o nome do pokemon que você deseja escolher");
  //       pokemon_escolhido = Pokemon.pokemon.fromName(scanner.next());
  //       if (pokemon_escolhido != null) {
  //         pokemon_valido = true;
  //       } else {
  //         System.out.println("\nXX Não foi possível encontrar este pokemon, tente outro XX\n");
  //       }
  //     } while (!pokemon_valido);
  //     pokemons[i] = new Pokemon(pokemon_escolhido.getName(), pokemon_escolhido.getTipos(),
  //         null);
  //   }
  // }

  // função para pegar a lista de pokemons

  public Pokemon getPokemon(int index){
    return pokemons.get(index);
  }

  public void setPokemonAtual(int index){
    this.pokemon_atual = index;
  }
  public Pokemon getPokemonAtual(){
    return pokemons.get(pokemon_atual);
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

  public String getName(){
    return this.nome;
  }
}
