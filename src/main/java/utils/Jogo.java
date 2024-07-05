package utils;
import java.util.ArrayList;
import java.util.Scanner;

class Jogo{
  // A lógica de jogo será implementada na parte 2
  private static boolean  temVencedor = false;
  private static int escolha;

  private static Savelog log = new Savelog();

  private static Jogador jogador1 = null;
  private static Jogador jogador2 = null;
  private static Jogador jogador_da_vez = null;
  private static Jogador jogador_inimigo = null;

  private static Class<? extends Ataque> at = null;

  // loop de turnos baseado na quantidade de pokemons de cada jogador
  public static void logicaJogo(){
    jogador_da_vez = jogador1;
    jogador_inimigo = jogador2;
  }
   
  

  public static void tick(){

    Scanner reader = new Scanner(System.in); // criando leitor do ataque

    if(temVencedor == false){

      Pokemon pokemon_da_vez = jogador_da_vez.getPokemonAtual();
      Pokemon pokemon_inimigo = jogador_inimigo.getPokemonAtual();

      switch (escolha) {
        case 1: // caso de ataque
          log.logAcao("Vai atacar", jogador_da_vez.getName());
          log.SalvaAcaoArquivo("log.java");
          pokemon_da_vez.ataca(pokemon_inimigo, at);
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
        System.out.printf("%s morreu", pokemon_inimigo);
        pokemon_inimigo.setNome(pokemon_inimigo.getNome()+" (Morto)");
        pokemon_inimigo.setAtaques(new ArrayList<>());
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

  public static Jogador getJogadorDaVez(){
    return jogador_da_vez;
  }

  public static Jogador getJogador2(){
    return jogador2;
  }

  // função para escolha da ação

  public static void setEscolha(int numero){
    escolha = numero;
  }

  public static void setAtaque(Class<? extends Ataque> ataque){
    at = ataque;
  }


}
