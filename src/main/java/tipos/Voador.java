package tipos;

import utils.Tipo;

import java.util.List;

public class Voador extends Tipo {

  static String tipo = "Voador";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = List.of(
      Terra.class
      );

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Eletrico.class,
      Gelo.class,
      Pedra.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Lutador.class,
      Planta.class
      );
}
