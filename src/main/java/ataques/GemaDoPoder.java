package ataques;

import utils.*;
import tipos.*;

public class GemaDoPoder extends Ataque{
        
  static String nome = "Gema do Poder";
  static int dano = 60;
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
