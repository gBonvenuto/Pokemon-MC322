package ataques;

import utils.*;
import tipos.*;

public class VisaoDoFuturo extends Ataque{
    static String nome = "Visão do futuro";
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
//psíquico
