package ataques;

import utils.*;
import tipos.*;

public class RodaDeChamas extends Ataque {
  static String nome = "Raio de chamas";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Fogo.class;

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
// fogo
