package ataques;

import utils.*;
import tipos.*;

public class Arranhao extends Ataque {

  static String nome = "Arranhão";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Normal.class;

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
// normal
