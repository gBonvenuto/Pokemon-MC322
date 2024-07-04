package tipos; 

import java.util.ArrayList;
import java.util.List;

import utils.Tipo;

public class Normal extends Tipo {

  static String tipo = "Normal";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = List.of(
      Fantasma.class
      );

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Lutador.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = new ArrayList<>(); // Normal não tem resistências
}
