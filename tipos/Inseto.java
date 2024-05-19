package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Inseto extends Tipo {

  static String tipo = "Inseto";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Inseto não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Voador.class,
      Veneno.class,
      Pedra.class,
      Fogo.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Lutador.class,
      Terra.class,
      Planta.class
      );
}
