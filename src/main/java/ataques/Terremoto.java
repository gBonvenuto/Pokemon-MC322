package ataques;

import utils.*;
import tipos.*;

public class Terremoto extends Ataque {
  static String nome = "Terremoto";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Terra.class;

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
// terra
