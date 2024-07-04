package utils;
import java.util.Scanner;

class Jogo{
  // A lógica de jogo será implementada na parte 2
  boolean temVencedor = false;
  int escolha;

  Savelog log = new Savelog();

  private static Jogador jogador1 = null;
  private static Jogador jogador2 = null;
  private static Jogador jogador_da_vez = null;
  private static Jogador jogador_inimigo = null;

  // loop de turnos baseado na quantidade de pokemons de cada jogador
  public static void logicaJogo(Jogador jogador1, Jogador jogador2){
    jogador_da_vez = jogador1;
    jogador_inimigo = jogador2;
  }
   
  

  public void tick(){

    Scanner reader = new Scanner(System.in); // criando leitor do ataque

    if(this.temVencedor = false){

      // 1. cada jogador escolhe o seu pokemon
      log.logAcao("Escolhe pokemon", jogador_da_vez.getName()); // fase de escolha de pokemon
      log.SalvaAcaoArquivo("log.java");
      int poke_index = reader.nextInt();
      Pokemon pokemon_da_vez = jogador_da_vez.getPokemon(poke_index); // temos o pokemon que vai atacar
      jogador_da_vez.setPokemonAtual(poke_index);
      
      log.logAcao("Escolhe pokemon", jogador_inimigo.getName()); // fase de escolha de pokemon
      log.SalvaAcaoArquivo("log.java");
      int poke_index2 = reader.nextInt();
      Pokemon pokemon_inimigo = jogador_inimigo.getPokemon(poke_index2);

      // geramos o menu
      System.out.println("******* Menu *******");
      System.out.println("1. Atacar\n2. Trocar Pokemon\n3. Correr");


      switch (escolha) {
        case 1: // caso de ataque
          log.logAcao("Vai atacar", jogador_da_vez.getName());
          log.SalvaAcaoArquivo("log.java");
          pokemon_da_vez.ataca(pokemon_inimigo);
          break;
      
        case 2: // caso de troca de pokemon - refaz a escolha do pokemon -
          log.logAcao("Vai trocar de Pokemon", jogador_da_vez.getName());;
          log.SalvaAcaoArquivo("log.java");
          int poke_troca = reader.nextInt(); // index do novo pokemon
          Pokemon pokemon_novo = jogador_da_vez.getPokemon(poke_troca);
          pokemon_da_vez = pokemon_novo;
          jogador_da_vez.setPokemonAtual(poke_troca);
          break;

        case 3: // caso de correr
          log.logAcao("Tentou fugir", jogador_da_vez.getName());
          log.SalvaAcaoArquivo("log.java");
          break;
      }
      if (pokemon_inimigo.getVida() <= 0){
        System.out.printf("%s venceu", jogador_da_vez);
        log.logAcao("Venceu", jogador_da_vez.getName());
        log.SalvaAcaoArquivo("log.java");
      }

      // mudança para o próximo jogador
      Jogador tmp = jogador_da_vez;
      jogador_da_vez = jogador_inimigo;
      jogador_inimigo = tmp;

    }
    reader.close();
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

  // função para escolha da ação

  public void setEscolha(int numero){
    this.escolha = numero;
  }


}