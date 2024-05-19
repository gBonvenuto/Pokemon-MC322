package ataques;

import utils.*;
import tipos.*;

public class ForcaFantasmagorica extends Ataque{
        
  static String nome = "Força Fantasmagórica";
  static int dano = 50;
  static Class<? extends Tipo> tipo = Fantasma.class;

  public String getNomeAtaque(){
    return nome;
}

}
// fantasma
