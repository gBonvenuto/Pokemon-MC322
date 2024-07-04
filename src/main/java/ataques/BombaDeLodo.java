package ataques;

import utils.*;
import tipos.*;

public class BombaDeLodo extends Ataque {
  static String nome = "Bomba de Lodo";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Veneno.class;

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
// veneno
