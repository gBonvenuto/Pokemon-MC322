package ataques;

import utils.*;
import tipos.*;

public class ArremessoDePedra extends Ataque {

  static String nome = "Arremesso de Pedra";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Pedra.class;

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
// pedra