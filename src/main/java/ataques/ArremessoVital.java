package ataques;

import utils.*;
import tipos.*;

public class ArremessoVital extends Ataque {

  static String nome = "Arremesso Vital";
  static int dano = 50;
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
