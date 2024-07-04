package ataques;

import utils.*;
import tipos.*;

public class Erupcao extends Ataque{
    
  static String nome = "Erupção";
  static int dano = 60;
  static Class<? extends Tipo> tipo = Fogo.class;

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
// fogo
