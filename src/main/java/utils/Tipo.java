package utils;

import java.util.ArrayList;

public abstract class Tipo {

  static String tipo = "";
  static String img; // Caminho para imagem do elemento
  static String resposta; // Resposta ao ataque
  static ArrayList<Tipo> imunidade; // Imunidade causa 0 de dano
  static ArrayList<Tipo> fraqueza; // Fraqueza gera o dobro do dano
  static ArrayList<Tipo> resistencia; // Resistencia causa metade do dano

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

  public String getDescricao() {
    return descricao;
  }

  public String getResposta() {
    return resposta;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  public void addImunidade(Tipo tipoImu) {
    imunidade.add(tipoImu);
  }

  public void addFraqueza(Tipo tipoFra) {
    fraqueza.add(tipoFra);
  }

  public void addResistencia(Tipo tipoRes) {
    resistencia.add(tipoRes);
  }

  public boolean buscaImunidade(Tipo elemento) {
    for (int i = 0; i < imunidade.size(); i++) {
      if (elemento.getTipo() == imunidade.get(i).getTipo()) {
        return true;
      }
    }
    return false;
  }

  public boolean buscaFraqueza(Tipo elemento) {
    for (int i = 0; i < fraqueza.size(); i++) {
      if (elemento.getTipo() == fraqueza.get(i).getTipo()) {
        return true;
      }
    }
    return false;
  }

  public boolean buscaResistencia(Tipo elemento) {
    for (int i = 0; i < resistencia.size(); i++) {
      if (elemento.getTipo() == resistencia.get(i).getTipo()) {
        return true;
      }
    }
    return false;
  }

}
