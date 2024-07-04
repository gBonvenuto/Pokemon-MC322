package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Fogo extends Tipo {

  static String tipo = "Fogo";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Fogo não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Terra.class,
      Pedra.class,
      Agua.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Inseto.class,
      Fogo.class,
      Planta.class
      );
}
