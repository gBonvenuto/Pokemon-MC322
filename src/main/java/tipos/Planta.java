package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Planta extends Tipo {

  static String tipo = "Planta";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Planta não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Voador.class,
      Veneno.class,
      Inseto.class,
      Fogo.class,
      Gelo.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Terra.class,
      Agua.class,
      Planta.class,
      Eletrico.class
      );
}
