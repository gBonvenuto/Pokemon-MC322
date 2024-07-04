package ataques;

import utils.*;
import tipos.*;

public class Surfar extends Ataque {
  static String nome = "Surfar";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Agua.class;

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
// água
