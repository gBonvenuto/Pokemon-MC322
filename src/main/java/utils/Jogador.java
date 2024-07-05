package utils;

import java.util.Scanner;


import java.util.List;

public class Jogador {

  Scanner scanner = new Scanner(System.in);
  private String nome;
  private List<Pokemon> pokemons; // Cada jogador terá somente 4 pokemons
  private int pokemon_atual = 0;

  public Jogador(String nome,  List<Pokemon> pokemons) {
    this.nome = nome;
    this.pokemons = pokemons;
  }

  public List<Pokemon> getPokemonList(){
    return pokemons;
  }
  
  public String[] getPokemonListString(){
    String[] list = new String[4];
    for (int i = 0; i < list.length; i++) {
      list[i] = pokemons.get(i).getNome();
    }
    return list;
  }

  public Pokemon getPokemon(int index){
    return pokemons.get(index);
  }

  public void setPokemonAtual(int index){
    this.pokemon_atual = index;
  }
  public Pokemon getPokemonAtual(){
    return pokemons.get(pokemon_atual);
  }
  public int getPokemonAtualIndex(){
    return pokemon_atual;
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
