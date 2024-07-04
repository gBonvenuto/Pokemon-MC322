package ataques;

import utils.*;
import tipos.*;

public class BafoDoDragao extends Ataque {

  static String nome = "Bafo do Dragão";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Dragao.class;
  
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
// dragão
