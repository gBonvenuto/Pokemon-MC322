package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Eletrico extends Tipo {

  static String tipo = "Fantasma";
  static String img = "path"; // Caminho para imagem do elemento

  @Override
  public String getTipo() {
    return tipo;
  }
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Eletrico não tem imunidade

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Terra.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Voador.class,
      Eletrico.class
      );
    
}
