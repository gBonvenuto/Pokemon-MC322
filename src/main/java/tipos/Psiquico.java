package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Psiquico extends Tipo {

  static String tipo = "Psíquico";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Psíquico não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Inseto.class,
      Fantasma.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Lutador.class,
      Psiquico.class
      );
}
