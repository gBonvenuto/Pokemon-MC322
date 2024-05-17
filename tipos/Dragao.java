package tipos;

import java.util.ArrayList;
import java.util.List;

import utils.Tipo;

public class Dragao extends Tipo {

  // TODO: Deixar todos os outros tipos nesse estilo
  static String tipo = "Dragão";
  static String img = "path"; // Caminho para imagem do elemento
  static String resposta = "sla"; // Resposta ao ataque
                                  
  // Imunidade causa 0 de dano
  static ArrayList<Tipo> imunidade = new ArrayList<>(); // Dragão não tem imunidade 

  // Fraquezas
  static List<Class<? extends Tipo>> fraqueza = List.of(
      Dragao.class,
      Gelo.class);

  // Resistencia causa metade do dano
  static List<Class<? extends Tipo>> resistencia = List.of(
      Fogo.class,
      Agua.class,
      Planta.class,
      Eletrico.class);
}
