package ataques;

import utils.*;
import tipos.*;

public class Brasa extends Ataque {

  static String nome = "Brasa";
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
