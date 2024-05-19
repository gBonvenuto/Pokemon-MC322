package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Pedra extends Tipo{

  static String tipo = "Pedra";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Pedra não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Lutador.class,
      Terra.class,
      Agua.class,
      Planta.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Normal.class,
      Voador.class,
      Veneno.class,
      Fogo.class
      );
}
