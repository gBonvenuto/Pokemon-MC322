package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tipos.*;

public class Pokemon {

  String nome;
  private int vida = 300; // todos os pokemons iniciam com 300 de vida

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

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Class<? extends Tipo>> getTipo() {
    return this.tipo;
  }

  public List<Class<? extends Ataque>> getAtaques() {
    return this.ataques;
  }

  public void setAtaques(List<Class<? extends Ataque>> ataques) {
    this.ataques = ataques;
  }

  public String[] getAtaquesString() {
    String[] lista = new String[30];
    int i = 0;
    for (Class<? extends Ataque> at : ataques) {
      try {
        lista[i] = at.getDeclaredConstructor().newInstance().getNome();
      } catch (Exception e) {
        System.err.println("Não foi possível listar esse ataque");
      }
      i++;
    }
    return lista;
  }

  public void reduzVida(int dano) {
    this.vida -= dano;
  }

  // método de atacar
  public void ataca(Pokemon pokemon, Class<? extends Ataque> at) {
    // deve escolher o ataque

    int dano = 0;

    Ataque ataque = null;

    try {
      ataque = at.getDeclaredConstructor().newInstance();
      dano = ataque.getDano();
    } catch (Exception e) {
      System.err.println("Não foi possível encontrar o ataque");
      return;
    }

    pokemon.reduzVida(dano); // alvo toma o dano

    Batalha_Interface.appendLog(getNome()+" atacou "+pokemon.getNome()+" utlizando "+ataque.getNome() + " causando "+ dano + " de dano");
    Savelog.log(getNome()+" atacou "+pokemon.getNome()+" utlizando "+ataque.getNome() + " causando "+ dano + " de dano");

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
    private List<Class<? extends Ataque>> ataques = new ArrayList<>();

    pokemon(int number, String name, List<Class<? extends Tipo>> tipos, List<Class<? extends Ataque>> ataques) {
      this.number = number;
      this.name = name;
      this.tipos = tipos;
      this.ataques = ataques;
    }

    // Essa função pega o enum pokemon e retorna um objeto Pokemon
    public Pokemon inicializarPokemon() {

      List<Class<? extends Ataque>> ataques = new ArrayList<>();

      Savelog.log("Inicializando o pokemon " + name);
      // Escolhendo ataques aleatórios baseados no tipo do pokemon
      for (int i = 0; i < 4; i++) {
        Class<? extends Ataque> at = null;

        while (true) { // Verificar se o ataque randomizado possui o mesmo tipo do pokemon
          Random rand = new Random();
          int index = rand.nextInt(0, Ataque.ataques.values().length - 1);
          at = Ataque.ataques.values()[index].getAtaque();
          Ataque ataque = null;
          try {
            ataque = at.getDeclaredConstructor().newInstance();
          } catch (Exception e) {
            System.err.println("Não foi possível definir esse ataque");
          }
          if (tipos.contains(ataque.getTipo())) {
            break;
          }
        }

        ataques.add(at);
      }

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
    public static String[] lista() {
      String[] lista = new String[30];
      for (pokemon pokemon : pokemon.values()) {
        lista[pokemon.number - 1] = pokemon.getName();
      }
      return lista;
    }

  }

}
