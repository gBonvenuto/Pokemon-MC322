import utils.*;
import tipos.*;

public class Main {

  public static void main(String[] args) {

    // Criacao dos tipos
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

    // Normal
    normal.addFraqueza(lutador);
    normal.addImunidade(fantasma);
    // Lutador
    lutador.addFraqueza(voador);
    lutador.addFraqueza(psiquico);
    lutador.addResistencia(pedra);
    lutador.addResistencia(inseto);
    // Voador
    voador.addFraqueza(pedra);
    voador.addFraqueza(eletrico);
    voador.addFraqueza(gelo);
    voador.addImunidade(pedra);
    voador.addResistencia(lutador);
    voador.addResistencia(planta);
    // Veneno
    veneno.addFraqueza(terra);
    veneno.addFraqueza(inseto);
    veneno.addFraqueza(psiquico);
    veneno.addResistencia(lutador);
    veneno.addResistencia(veneno);
    veneno.addResistencia(planta);
    // Terra
    terra.addFraqueza(agua);
    terra.addFraqueza(planta);
    terra.addFraqueza(gelo);
    terra.addImunidade(eletrico);
    terra.addResistencia(veneno);
    terra.addResistencia(pedra);
    // Pedra
    pedra.addFraqueza(lutador);
    pedra.addFraqueza(terra);
    pedra.addFraqueza(agua);
    pedra.addFraqueza(planta);
    pedra.addResistencia(normal);
    pedra.addResistencia(voador);
    pedra.addResistencia(veneno);
    pedra.addResistencia(fogo);
    // Inseto
    inseto.addFraqueza(voador);
    inseto.addFraqueza(veneno);
    inseto.addFraqueza(pedra);
    inseto.addFraqueza(fogo);
    inseto.addResistencia(lutador);
    inseto.addResistencia(terra);
    inseto.addResistencia(planta);
    // Fantasma
    fantasma.addFraqueza(fantasma);
    fantasma.addImunidade(normal);
    fantasma.addImunidade(lutador);
    fantasma.addResistencia(veneno);
    fantasma.addResistencia(inseto);
    // Fogo
    fogo.addFraqueza(terra);
    fogo.addFraqueza(pedra);
    fogo.addFraqueza(agua);
    fogo.addResistencia(inseto);
    fogo.addResistencia(fogo);
    fogo.addResistencia(planta);
    // Agua
    agua.addFraqueza(planta);
    agua.addFraqueza(eletrico);
    agua.addResistencia(fogo);
    agua.addResistencia(agua);
    agua.addResistencia(gelo);
    // Planta
    planta.addFraqueza(voador);
    planta.addFraqueza(veneno);
    planta.addFraqueza(inseto);
    planta.addFraqueza(fogo);
    planta.addFraqueza(gelo);
    planta.addResistencia(terra);
    planta.addResistencia(agua);
    planta.addResistencia(planta);
    planta.addResistencia(eletrico);
    // Eletrico
    eletrico.addFraqueza(terra);
    eletrico.addResistencia(voador);
    eletrico.addResistencia(eletrico);
    // Psiquico
    psiquico.addFraqueza(inseto);
    psiquico.addFraqueza(fantasma);
    psiquico.addResistencia(lutador);
    psiquico.addResistencia(psiquico);
    // Gelo
    gelo.addFraqueza(lutador);
    gelo.addFraqueza(pedra);
    gelo.addFraqueza(fogo);
    gelo.addResistencia(gelo);
    // Dragao

    {}
  }

}
