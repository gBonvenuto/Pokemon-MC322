package ataques;

import utils.*;
import tipos.*;

public class Pesadelo extends Ataque {
  static String nome = "Pesadelo";
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
