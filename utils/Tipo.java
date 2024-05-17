package utils;

import java.util.ArrayList;

import tipos.Normal;
import tipos.Agua;
import tipos.Dragao;
import tipos.Eletrico;
import tipos.Fantasma;
import tipos.Fogo;
import tipos.Gelo;
import tipos.Inseto;
import tipos.Lutador;
import tipos.Pedra;
import tipos.Planta;
import tipos.Psiquico;
import tipos.Terra;
import tipos.Veneno;
import tipos.Voador;

public class Tipo {

    private String tipo = "";
    private String img; //Caminho para imagem do elemento
    private String descricao; //Descricao do ataque
    private String resposta; //Resposta ao ataque
    ArrayList<Tipo> imunidade; //Imunidade causa 0 de dano
    ArrayList<Tipo> fraqueza; //Fraqueza gera o dobro do dano
    ArrayList<Tipo> resistencia; //Resistencia causa metade do dano

    //Construtor para golpe
    public Tipo (String descricao, String resposta){
        this.descricao = descricao;
        this.resposta = resposta;
        imunidade = new ArrayList<Tipo>();
        fraqueza = new ArrayList<Tipo>();
        resistencia = new ArrayList<Tipo>();
    }

    //Construtor para tipos diferentes
    public Tipo (String img){
        this.img = img;
        imunidade = new ArrayList<Tipo>();
        fraqueza = new ArrayList<Tipo>();
        resistencia = new ArrayList<Tipo>();
    }

    public String getTipo(){
        return tipo;
    }

    public String getImg(){
        return img;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getResposta(){
        return resposta;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setImg(String img){
        this.img = img;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setResposta(String resposta){
        this.resposta = resposta;
    }

    public void addImunidade(Tipo tipoImu){
        imunidade.add(tipoImu);
    }

    public void addFraqueza(Tipo tipoFra){
        fraqueza.add(tipoFra);
    }

    public void addResistencia(Tipo tipoRes){
        resistencia.add(tipoRes);
    }

    public boolean buscaImunidade(Tipo elemento){
        for (int i = 0; i<imunidade.size(); i++){
            if(elemento.getTipo() == imunidade.get(i).getTipo()){
                return true;
            }
        }
        return false;
    }

    public boolean buscaFraqueza(Tipo elemento){
        for (int i = 0; i<fraqueza.size(); i++){
            if(elemento.getTipo() == fraqueza.get(i).getTipo()){
                return true;
            }
        }
        return false;
    }

    public boolean buscaResistencia(Tipo elemento){
        for (int i = 0; i<resistencia.size(); i++){
            if(elemento.getTipo() == resistencia.get(i).getTipo()){
                return true;
            }
        }
        return false;
    }
}

public static void main(String[] args){

    //Criacao dos tipos
    Normal normal = new Normal("path");
    Agua agua = new Agua("path");
    Dragao dragao = new Dragao("path");
    Eletrico eletrico = new Eletrico("path");
    Fantasma fantasma = new Fantasma("path");
    Fogo fogo = new Fogo("path");
    Gelo gelo = new Gelo("path");
    Inseto inseto = new Inseto("path");
    Lutador lutador = new Lutador("path");
    Pedra pedra = new Pedra("path");
    Planta planta = new Planta("path");
    Psiquico psiquico = new Psiquico("path");
    Terra terra = new Terra("path");
    Veneno veneno = new Veneno("path");
    Voador voador = new Voador("path");

    //Normal
    normal.addFraqueza(lutador);
    normal.addImunidade(fantasma);
    //Lutador
    lutador.addFraqueza(voador);
    lutador.addFraqueza(psiquico);
    lutador.addResistencia(pedra);
    lutador.addResistencia(inseto);
    //Voador
    voador.addFraqueza(pedra);
    voador.addFraqueza(eletrico);
    voador.addFraqueza(gelo);
    voador.addImunidade(pedra);
    voador.addResistencia(lutador);
    voador.addResistencia(planta);
    //Veneno
    veneno.addFraqueza(terra);
    veneno.addFraqueza(inseto);
    veneno.addFraqueza(psiquico);
    veneno.addResistencia(lutador);
    veneno.addResistencia(veneno);
    veneno.addResistencia(planta);
    //Terra
    terra.addFraqueza(agua);
    terra.addFraqueza(planta);
    terra.addFraqueza(gelo);
    terra.addImunidade(eletrico);
    terra.addResistencia(veneno);
    terra.addResistencia(pedra);
    //Pedra
    pedra.addFraqueza(lutador);
    pedra.addFraqueza(terra);
    pedra.addFraqueza(agua);
    pedra.addFraqueza(planta);
    pedra.addResistencia(normal);
    pedra.addResistencia(voador);
    pedra.addResistencia(veneno);
    pedra.addResistencia(fogo);
    //Inseto
    inseto.addFraqueza(voador);
    inseto.addFraqueza(veneno);
    inseto.addFraqueza(pedra);
    inseto.addFraqueza(fogo);
    inseto.addResistencia(lutador);
    inseto.addResistencia(terra);
    inseto.addResistencia(planta);
    //Fantasma
    fantasma.addFraqueza(fantasma);
    fantasma.addImunidade(normal);
    fantasma.addImunidade(lutador);
    fantasma.addResistencia(veneno);
    fantasma.addResistencia(inseto);
    //Fogo
    fogo.addFraqueza(terra);
    fogo.addFraqueza(pedra);
    fogo.addFraqueza(agua);
    fogo.addResistencia(inseto);
    fogo.addResistencia(fogo);
    fogo.addResistencia(planta);
    //Agua
    agua.addFraqueza(planta);
    agua.addFraqueza(eletrico);
    agua.addResistencia(fogo);
    agua.addResistencia(agua);
    agua.addResistencia(gelo);
    //Planta
    planta.addFraqueza(voador);
    planta.addFraqueza(veneno);
    planta.addFraqueza(inseto);
    planta.addFraqueza(fogo);
    planta.addFraqueza(gelo);
    planta.addResistencia(terra);
    planta.addResistencia(agua);
    planta.addResistencia(planta);
    planta.addResistencia(eletrico);
    //Eletrico
    eletrico.addFraqueza(terra);
    eletrico.addResistencia(voador);
    eletrico.addResistencia(eletrico);
    //Psiquico
    psiquico.addFraqueza(inseto);
    psiquico.addFraqueza(fantasma);
    psiquico.addResistencia(lutador);
    psiquico.addResistencia(psiquico);
    //Gelo
    gelo.addFraqueza(lutador);
    gelo.addFraqueza(pedra);
    gelo.addFraqueza(fogo);
    gelo.addResistencia(gelo);
    //Dragao
    dragao.addFraqueza(gelo);
    dragao.addFraqueza(dragao);
    dragao.addResistencia(fogo);
    dragao.addResistencia(agua);
    dragao.addResistencia(planta);
    dragao.addResistencia(eletrico);
} 