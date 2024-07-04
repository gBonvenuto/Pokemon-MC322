package tipos;

import utils.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Veneno extends Tipo {

  static String tipo = "Veneno";
  static String img = "path"; // Caminho para imagem do elemento
                                  
  // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> imunidade = new ArrayList<>(); // Veneno não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Terra.class,
      Inseto.class,
      Psiquico.class
      );

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Lutador.class,
      Veneno.class,
      Planta.class
      );
}
