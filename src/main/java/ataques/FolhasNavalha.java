package ataques;

import utils.*;
import tipos.*;

public class FolhasNavalha extends Ataque{
        
  static String nome = "Folhas Navalha";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Planta.class;

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
// planta
