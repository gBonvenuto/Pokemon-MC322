package ataques;

import utils.*;
import tipos.*;

public class SocoFocado extends Ataque {
  static String nome = "Soco focado";
  static int dano = 60;
  static Class<? extends Tipo> tipo = Lutador.class;

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
// lutador
