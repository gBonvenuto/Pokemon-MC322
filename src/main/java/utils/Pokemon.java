package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tipos.*;

public class Pokemon {

  // iniciando a classe pokemon

  // variáveis
  String nome;
  int vida = 100; // todos os pokemons iniciam com 100 de vida

  // vraiáveis espciais
  Tipo tipo; // todo pokemon possui um tipo espcífico --> apenas um por pokemon

  Ataque ataque;// todo pokemon pode atacar

  ArrayList<Ataque> ataques = new ArrayList<>();

  public Pokemon(String nome, Tipo tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }

  // métodos implementação

  public int getVida() {
    return this.vida;
  }

  public String getNome() {
    return this.nome;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  // método de atacar
  public int ataca(Pokemon pokemon) {
    // deve escolher o ataque --> é bom que isso seja uma subescolha de um menu de
    // ações
    Scanner sc = new Scanner(System.in);
    System.out.println("Escolha o ataque"); // suponho que exista uma função getNomeAtaque

    int i = 0;
    int dano;
    for (Ataque at : ataques) {
      i++;
      System.out.println(i + at.getNome());
    }

    int escolha = sc.nextInt();

    do {
      System.out.println("Escolha um número de 1 a 4:");
      while (!sc.hasNextInt()) {
        System.out.println("Entrada inválida. Por favor, insira um número."); // resolve se o usuário inserir nada
        sc.next(); // Limpar entrada inválida
      }

      escolha = sc.nextInt();

      dano = switch (escolha) {
        case 1 -> ataques.get(0).getDano(); // suponho a existência de um método getDano na classe Ataque

        case 2 -> ataques.get(1).getDano();

        case 3 -> ataques.get(2).getDano();

        case 4 -> ataques.get(3).getDano();

        default -> -1;

        // TODO: printar a seguinte mensagem se retornar -1
        // System.out.println("Escolha inválida. Por favor, insira um número entre 1 e
        // 4.");
      };

    } while (escolha < 1 || escolha > 4); // restringe a escolha do usuário

    sc.close();
    return dano;
  }

  public void defender(Ataque ataque, int dano) { // na função de lógica de jogo eu vou ter que lembrar disso ( associar
                                                  // o ataque de um pokemon ao outro)

    // puxar os métodos de defesa da classe tipo
    this.tipo.defesa(ataque);
  }

  public static enum pokemon {
    BULBASAUR(1, "Bulbasaur", List.of(Planta.class, Veneno.class)),
    IVYSAUR(2, "Ivysaur", List.of(Planta.class, Veneno.class)),
    VENUSAUR(3, "Venusaur", List.of(Planta.class, Veneno.class)),
    CHARMANDER(4, "Charmander", List.of(Fogo.class)),
    CHARMELEON(5, "Charmeleon", List.of(Fogo.class)),
    CHARIZARD(6, "Charizard", List.of(Fogo.class, Voador.class)),
    SQUIRTLE(7, "Squirtle", List.of(Agua.class)),
    WARTORTLE(8, "Wartortle", List.of(Agua.class)),
    BLASTOISE(9, "Blastoise", List.of(Agua.class)),
    CATERPIE(10, "Caterpie", List.of(Inseto.class)),
    METAPOD(11, "Metapod", List.of(Inseto.class)),
    BUTTERFREE(12, "Butterfree", List.of(Inseto.class, Voador.class)),
    WEEDLE(13, "Weedle", List.of(Inseto.class, Veneno.class)),
    KAKUNA(14, "Kakuna", List.of(Inseto.class, Veneno.class)),
    BEEDRILL(15, "Beedrill", List.of(Inseto.class, Veneno.class)),
    PIDGEY(16, "Pidgey", List.of(Normal.class, Voador.class)),
    PIDGEOTTO(17, "Pidgeotto", List.of(Normal.class, Voador.class)),
    PIDGEOT(18, "Pidgeot", List.of(Normal.class, Voador.class)),
    RATTATA(19, "Rattata", List.of(Normal.class)),
    RATICATE(20, "Raticate", List.of(Normal.class)),
    SPEAROW(21, "Spearow", List.of(Normal.class, Voador.class)),
    FEAROW(22, "Fearow", List.of(Normal.class, Voador.class)),
    EKANS(23, "Ekans", List.of(Veneno.class)),
    ARBOK(24, "Arbok", List.of(Veneno.class)),
    PIKACHU(25, "Pikachu", List.of(Eletrico.class)),
    RAICHU(26, "Raichu", List.of(Eletrico.class)),
    SANDSHREW(27, "Sandshrew", List.of(Pedra.class)),
    SANDSLASH(28, "Sandslash", List.of(Pedra.class)),
    NIDORAN_FEMALE(29, "Nidoran♀", List.of(Veneno.class)),
    NIDORINA(30, "Nidorina", List.of(Veneno.class));

    private final int number;
    private final String name;
    private final List<Class<? extends Tipo>> tipos;

    pokemon(int number, String name, List<Class<? extends Tipo>> tipos) {
      this.number = number;
      this.name = name;
      this.tipos = tipos;
    }

    public int getNumber() {
      return number;
    }

    public String getName() {
      return name;
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

  }

}
