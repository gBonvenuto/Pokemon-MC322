package tipos;

import java.util.ArrayList;
import java.util.List;

import utils.Tipo;

public class Dragao extends Tipo {

  static String tipo = "Dragão";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Dragão não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Dragao.class,
      Gelo.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Fogo.class,
      Agua.class,
      Planta.class,
      Eletrico.class
      );
}
