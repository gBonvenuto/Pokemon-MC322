package utils;

import java.util.List;

public abstract class Tipo {

  static String tipo = "";
  static String img; // Caminho para imagem do elemento
  static String resposta; // Resposta ao ataque
  static List<Class<? extends Tipo>> imunidade; // Imunidade causa 0 de dano
  static List<Class<? extends Tipo>> fraqueza; // Fraqueza gera o dobro do dano
  static List<Class<? extends Tipo>> resistencia; // Resistencia causa metade do dano

  // Esta função calcula a quantidade de dano que o Tipo Dragão deve levar
  // dependendo do golpe que ele levou
  public int defesa(Ataque golpe) {
    if (this.buscaFraqueza(golpe.getTipo())) {
      return 2 * golpe.getDano();
    } else if (this.buscaImunidade(golpe.getTipo())) {
      return 0;
    } else if (this.buscaResistencia(golpe.getTipo())) {
      return (1 / 2) * golpe.getDano();
    }
    return golpe.getDano();
  }

  public String getTipo() {
    return tipo;
  }

  public String getImg() {
    return img;
  }

  public String getResposta() {
    return resposta;
  }

  public boolean buscaImunidade(Class<? extends Tipo> elemento) {
    for (int i = 0; i < imunidade.size(); i++) {
      if (elemento == imunidade.get(i)) {
        return true;
      }
    }
    return false;
  }

  public boolean buscaFraqueza(Class<? extends Tipo> elemento) {
    for (int i = 0; i < fraqueza.size(); i++) {
      if (elemento == fraqueza.get(i)) {
        return true;
      }
    }
    return false;
  }

  public boolean buscaResistencia(Class<? extends Tipo> elemento) {
    for (int i = 0; i < resistencia.size(); i++) {
      if (elemento == resistencia.get(i)) {
        return true;
      }
    }
    return false;
  }

}
