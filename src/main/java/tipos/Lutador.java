package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Lutador extends Tipo {

  static String tipo = "Lutador";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Dragão não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Voador.class,
      Psiquico.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Pedra.class,
      Inseto.class
      );
}
