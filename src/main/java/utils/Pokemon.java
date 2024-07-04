package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tipos.*;

public class Pokemon {

  String nome;
  int vida = 300; // todos os pokemons iniciam com 300 de vida

  List<Class<? extends Tipo>> tipo;
  List<Class<? extends Ataque>> ataques = new ArrayList<>();  
  // tipo e ataques são listas das classes e não listas de objetos porque não
  // é necessário instanciar um objeto do ataque. Todos os seus métodos são
  // estáticos de forma a melhorar a performance do jogo.

  public Pokemon(String nome, List<Class<? extends Tipo>> tipo, List<Class<? extends Ataque>> ataques) {
    this.nome = nome;
    this.tipo = tipo;
    this.ataques = ataques;
  }

  public int getVida() {
    return this.vida;
  }

  public String getNome() {
    return this.nome;
  }

  public List<Class<? extends Tipo>> getTipo() {
    return this.tipo;
  }
  public List<Class<? extends Ataque>> getAtaques() {
    return this.ataques;
  }

  // método de atacar
  public int ataca(Pokemon pokemon) {
    // deve escolher o ataque
    Scanner sc = new Scanner(System.in);
    System.out.println("Escolha o ataque"); 

    int i = 0;
    int dano = 0;
    for (Class<? extends Ataque> at : ataques) {
      Ataque ataque;
      try {
        ataque = at.getDeclaredConstructor().newInstance();
      } catch (Exception e) {
        System.err.println("Não foi possível encontrar o ataque");
        break;
      }
      i++;
      System.out.println(i + ataque.getNome());
    }

    int escolha = sc.nextInt();

    do {
      System.out.println("Escolha um número de 1 a 4:");
      while (!sc.hasNextInt()) {
        System.out.println("Entrada inválida. Por favor, insira um número."); // resolve se o usuário inserir nada
        sc.next(); // Limpar entrada inválida
      }

      escolha = sc.nextInt();

      // Cada pokemon tem 4 ataques 
      try {
        dano = switch (escolha) {

          case 1 -> (int) ataques.get(0).getMethod("getDano").invoke(null);

          case 2 -> (int) ataques.get(1).getMethod("getDano").invoke(null);

          case 3 -> (int) ataques.get(2).getMethod("getDano").invoke(null);

          case 4 -> (int) ataques.get(3).getMethod("getDano").invoke(null);

          default -> -1;

        };
      } catch (Exception e) {
        System.err.println("Não foi possível acessar esse ataque");
      }

    } while (escolha < 1 || escolha > 4); // restringe a escolha do usuário

    sc.close();
    return dano;
  }

                                                  // o ataque de um pokemon ao outro)
  public void defender(Ataque ataque, int dano) { // na função de lógica de jogo eu vou ter que lembrar disso ( associar
    // puxar os métodos de defesa da classe tipo
    try {
      this.tipo.getClass().getMethod("defesa").invoke(ataque);
    } catch (Exception e) {
      System.err.println("Não foi possível acessar essa defesa");
    }
    }

  // Temos enum de pokemons que são possíveis escolher.
  public static enum pokemon {
    BULBASAUR(1, "Bulbasaur", List.of(Planta.class, Veneno.class), new ArrayList<>()),
    IVYSAUR(2, "Ivysaur", List.of(Planta.class, Veneno.class), new ArrayList<>()),
    VENUSAUR(3, "Venusaur", List.of(Planta.class, Veneno.class), new ArrayList<>()),
    CHARMANDER(4, "Charmander", List.of(Fogo.class), new ArrayList<>()),
    CHARMELEON(5, "Charmeleon", List.of(Fogo.class), new ArrayList<>()),
    CHARIZARD(6, "Charizard", List.of(Fogo.class, Voador.class), new ArrayList<>()),
    SQUIRTLE(7, "Squirtle", List.of(Agua.class), new ArrayList<>()),
    WARTORTLE(8, "Wartortle", List.of(Agua.class), new ArrayList<>()),
    BLASTOISE(9, "Blastoise", List.of(Agua.class), new ArrayList<>()),
    CATERPIE(10, "Caterpie", List.of(Inseto.class), new ArrayList<>()),
    METAPOD(11, "Metapod", List.of(Inseto.class), new ArrayList<>()),
    BUTTERFREE(12, "Butterfree", List.of(Inseto.class, Voador.class), new ArrayList<>()),
    WEEDLE(13, "Weedle", List.of(Inseto.class, Veneno.class), new ArrayList<>()),
    KAKUNA(14, "Kakuna", List.of(Inseto.class, Veneno.class), new ArrayList<>()),
    BEEDRILL(15, "Beedrill", List.of(Inseto.class, Veneno.class), new ArrayList<>()),
    PIDGEY(16, "Pidgey", List.of(Normal.class, Voador.class), new ArrayList<>()),
    PIDGEOTTO(17, "Pidgeotto", List.of(Normal.class, Voador.class), new ArrayList<>()),
    PIDGEOT(18, "Pidgeot", List.of(Normal.class, Voador.class), new ArrayList<>()),
    RATTATA(19, "Rattata", List.of(Normal.class), new ArrayList<>()),
    RATICATE(20, "Raticate", List.of(Normal.class), new ArrayList<>()),
    SPEAROW(21, "Spearow", List.of(Normal.class, Voador.class), new ArrayList<>()),
    FEAROW(22, "Fearow", List.of(Normal.class, Voador.class), new ArrayList<>()),
    EKANS(23, "Ekans", List.of(Veneno.class), new ArrayList<>()),
    ARBOK(24, "Arbok", List.of(Veneno.class), new ArrayList<>()),
    PIKACHU(25, "Pikachu", List.of(Eletrico.class), new ArrayList<>()),
    RAICHU(26, "Raichu", List.of(Eletrico.class), new ArrayList<>()),
    SANDSHREW(27, "Sandshrew", List.of(Pedra.class), new ArrayList<>()),
    SANDSLASH(28, "Sandslash", List.of(Pedra.class), new ArrayList<>()),
    NIDORAN_FEMALE(29, "Nidoran♀", List.of(Veneno.class), new ArrayList<>()),
    NIDORINA(30, "Nidorina", List.of(Veneno.class), new ArrayList<>());

    private final int number;
    private final String name;
    private final List<Class<? extends Tipo>> tipos;
    private List<Class<? extends Ataque>> ataques;

    pokemon(int number, String name, List<Class<? extends Tipo>> tipos, List<Class<? extends Ataque>> ataques) {
      this.number = number;
      this.name = name;
      this.tipos = tipos;
      this.ataques = ataques;
    }

    // Essa função pega o enum pokemon e retorna um objeto Pokemon
    public Pokemon inicializarPokemon(){
      Pokemon pokemon_objeto = new Pokemon(name, tipos, ataques);
      return pokemon_objeto;
    }

    public int getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }

    public List<Class<? extends Ataque>> getAtaques() {
      return ataques;
    }

    public void addAtaque(Class<? extends Ataque> ataque) {
      ataques.add(ataque);
    }

    public List<Class<? extends Tipo>> getTipos() {
      return tipos;
    }

    @Override
    public String toString() {
      return number + " - " + name + tipos;
    }

    public static pokemon fromName(String nome) {
      for (pokemon pokemon : pokemon.values()) {
        if (pokemon.getName().equalsIgnoreCase(nome)) {
          return pokemon;
        }
      }
      return null;
    }

    // Printa uma lista no stdout
    public static void lista() {
      for (pokemon pokemon : pokemon.values()) {
        System.out.println("\t" + pokemon.getName());
      }
    }

  }

}
