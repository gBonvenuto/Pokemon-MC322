package tipos;

import utils.Tipo;

import java.util.List;

public class Terra extends Tipo {

  static String tipo = "Terra";
  static String img = "path"; // Caminho para imagem do elemento

  @Override
  public String getTipo() {
    return tipo;
  }
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = List.of(
      Eletrico.class
      );

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Agua.class,
      Planta.class,
      Gelo.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Veneno.class,
      Pedra.class
      );
}
