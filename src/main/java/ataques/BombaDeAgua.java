package ataques;

import utils.*;
import tipos.*;

public class BombaDeAgua extends Ataque {

  static String nome = "Bomba de Água";
  static int dano = 60;
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