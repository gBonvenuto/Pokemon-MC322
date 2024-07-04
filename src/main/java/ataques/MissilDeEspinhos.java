package ataques;

import utils.*;
import tipos.*;

public class MissilDeEspinhos extends Ataque {
  static String nome = "Míssel de espinhos";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Inseto.class;

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
// inseto
