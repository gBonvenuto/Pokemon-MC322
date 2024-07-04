package main;
import utils.*;

public class Main {
  public static void main(String[] args) {
    InicializarJogador_Interface.main(args); // Inicializa a interface
    Savelog log = new Savelog();
    log.logAcao("iniciando o jogo", null);
    log.SalvaAcaoArquivo("log.java");
  }
}
