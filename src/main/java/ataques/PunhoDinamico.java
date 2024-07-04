package ataques;

import utils.*;
import tipos.*;

public class PunhoDinamico extends Ataque {
  static String nome = "Punho dinâmico";
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
