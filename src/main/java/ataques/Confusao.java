package ataques;

import utils.*;
import tipos.*;

public class Confusao extends Ataque {

  static String nome = "Confusão";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Psiquico.class;

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
// psíquico
