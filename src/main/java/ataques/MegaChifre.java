package ataques;

import utils.*;
import tipos.*;

public class MegaChifre extends Ataque{
    static String nome = "Mega chifre";
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
//inseto