package ataques;

import utils.*;
import tipos.*;

public class GarraDoDragao extends Ataque{
        
  static String nome = "Garra do Dragão";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Dragao.class;

  public String getNomeAtaque(){
    return nome;
}
}
// dragão
