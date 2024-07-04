package ataques;

import utils.*;
import tipos.*;

public class CortesFuriosos extends Ataque {

  static String nome = "Cortes Furiosos";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Inseto.class;

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public int getDano() {
    return dano;
  }

  @Override
  public Class<? extends Tipo> getTipo() {
    return tipo;
  }

}
// inseto
