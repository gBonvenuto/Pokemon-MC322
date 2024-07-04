package tipos;

import utils.Tipo;

import java.util.List;

public class Fantasma extends Tipo {

  static String tipo = "Fantasma";
  static String img = "path"; // Caminho para imagem do elemento

  @Override
  public String getTipo() {
    return tipo;
  }
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = List.of(
      Normal.class,
      Lutador.class
      ); 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Fantasma.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Veneno.class,
      Inseto.class
      );

}
