package ataques;

import utils.*;
import tipos.*;

public class Susto extends Ataque {
  static String nome = "Susto";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Fantasma.class;

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
// fantasma
