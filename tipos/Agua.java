package tipos;

import utils.Ataque;
import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Agua extends Tipo {

  static String tipo = "Água";
  static String img = "path"; // Caminho para imagem do elemento

  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Agua não tem imunidade

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Planta.class,
      Eletrico.class);

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Fogo.class,
      Agua.class,
      Gelo.class);
}
