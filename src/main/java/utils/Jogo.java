package utils;
import java.util.Random;
import java.util.Scanner;

class Jogo{
  // A lógica de jogo será implementada na parte 2
  boolean temVencedor = false;


  private static Jogador jogador1 = null;
  private static Jogador jogador2 = null;

  // loop de turnos baseado na quantidade de pokemons de cada jogador
  public boolean logicaJogo(Jogador jogador1, Jogador jogador2){
    Scanner reader = new Scanner(System.in); // criando leitor do ataque
  
    // fazer um random para saber qual jogador vai começar primeiro
    Random random = new Random();
    int moeda = random.nextInt(1,2);

    // ordem de jogo
    Jogador jogador_da_vez; // vai oscilar entre jogador 1 ou 2
    Jogador jogador_inimigo; // vai oscilar entre 1 ou 2
    
    switch (moeda) {
      case 1:
        jogador_da_vez = jogador1;
        jogador_inimigo = jogador2;
        break;
      case 2:
        jogador_da_vez = jogador2;
        jogador_inimigo = jogador1;
        break;
      default:
        System.out.println("Algo deu errado");
        reader.close();
        return false;
    }

    while (this.temVencedor = false){


      // 1. cada jogador escolhe o seu pokemon
      System.out.printf("%s escolha o pokemon a atacar", jogador_da_vez.getName()); // fase de escolha de pokemon
      int poke_index = reader.nextInt();
      Pokemon pokemon_da_vez = jogador_da_vez.getPokemon(poke_index); // temos o pokemon que vai atacar
      jogador_da_vez.setPokemonAtual(poke_index);
      
      System.out.printf("%s escolha o pokemon a atacar", jogador_inimigo); // fase de escolha de pokemon
      int poke_index2 = reader.nextInt();
      Pokemon pokemon_inimigo = jogador_inimigo.getPokemon(poke_index2);

      // geramos o menu
      System.out.println("******* Menu *******");
      System.out.println("1. Atacar\n2. Trocar Pokemon\n3. Correr");

      int escolha = reader.nextInt();

      switch (escolha) {
        case 1: // caso de ataque
          System.out.printf("%s ataca", jogador_da_vez.getName());
          pokemon_da_vez.ataca(pokemon_inimigo);
          break;
      
        case 2: // caso de troca de pokemon - refaz a escolha do pokemon -
          System.out.printf("%s vai trocar de pokemon", jogador_da_vez.getName());
          int poke_troca = reader.nextInt(); // index do novo pokemon
          Pokemon pokemon_novo = jogador_da_vez.getPokemon(poke_troca);
          pokemon_da_vez = pokemon_novo;
          jogador_da_vez.setPokemonAtual(poke_troca);
          break;

        case 3: // caso de correr
          System.out.printf("%s tentou fugir", jogador_da_vez.getName());
          break;
      }
      if (pokemon_inimigo.getVida() <= 0){
        System.out.printf("%s venceu", jogador_da_vez);
      }

      // mudança para o próximo jogador
      Jogador tmp = jogador_da_vez;
      jogador_da_vez = jogador_inimigo;
      jogador_inimigo = tmp;

    }
    // fechamento do reader
    reader.close();

    return temVencedor = true;
  }

  public static void setJogador1(Jogador jogador){
    jogador1 = jogador;
  }

  public static Jogador getJogador1(){
    return jogador1;
  }

  public static void setJogador2(Jogador jogador){
    jogador2 = jogador;
  }

  public static Jogador getJogador2(){
    return jogador2;
  }


}
