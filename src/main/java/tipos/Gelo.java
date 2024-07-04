package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Gelo extends Tipo {

  static String tipo = "Gelo";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Gelo não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Lutador.class,
      Pedra.class,
      Fogo.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Gelo.class
      );
}
