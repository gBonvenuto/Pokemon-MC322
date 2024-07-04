package ataques;

import utils.*;
import tipos.*;

public class ExtraSensorial extends Ataque{
        
  static String nome = "Extra-Sensorial";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Psiquico.class;
  
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
// psíquico
