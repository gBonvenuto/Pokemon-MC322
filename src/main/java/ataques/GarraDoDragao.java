package ataques;

import utils.*;
import tipos.*;

public class GarraDoDragao extends Ataque{
        
  static String nome = "Garra do Dragão";
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
