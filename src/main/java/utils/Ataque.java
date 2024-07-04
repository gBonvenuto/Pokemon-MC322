package utils;

import ataques.*;

public abstract class Ataque {

  static String nome;
  static int dano;
  static Class<? extends Tipo> tipo; // Todo ataque possui um tipo próprio

  public String getNome() {
    return nome;
  }

  public int getDano() {
    return dano;
  }

  public Class<? extends Tipo> getTipo() {
    return tipo;
  }

  // Todos os ataques estão enumerados para que possam ser escolhidos de forma
  // aleatória no momento que o jogador escolhe o pokemon
  public static enum ataques {

    ACIDO(Acido.class),
    ARRANHAO(Arranhao.class),
    ArremessoDePedra(ArremessoDePedra.class),
    ARREMESSOVITAL(ArremessoVital.class),
    BAFODODRAGAO(BafoDoDragao.class),
    BOMBADEAGUA(BolhaDeAgua.class),
    BOMBADELODO(BombaDeLodo.class),
    BRASA(Brasa.class),
    CABECADA(Cabecada.class),
    CAVAR(Cavar.class),
    CHICOTEDEVINHAS(ChicoteDeVinhas.class),
    CHUTEDUPLO(ChuteDuplo.class),
    CONFUSAO(Confusao.class),
    CORTESFURIOSOS(CortesFuriosos.class),
    DANCADASPETALAS(DancaDasPetalas.class),
    DESLIZAMENTODEPEDRA(DeslizamentoDePedra.class),
    ERUPCAO(Erupcao.class),
    ESPINHOSVENENOSOS(EspinhosVenenosos.class),
    EXTRASENSORIAL(ExtraSensorial.class),
    FOLHASNAVALHA(FolhasNavalha.class),
    FORCAFANTASMAGORICA(ForcaFantasmagorica.class),
    GARRADODRAGAO(GarraDoDragao.class),
    GEMADOPODER(GemaDoPoder.class),
    INVESTIDA(Investida.class),
    JATODEAGUA(JatoDeAgua.class),
    LANCACHAMAS(LancaChamas.class),
    MALDICAO(Maldicao.class),
    MEGACHIFRE(MegaChifre.class),
    MISSILDEESPINHOS(MissilDeEspinhos.class),
    MORDIDADEINSETO(MordidaDeInseto.class),
    PANCADACORPORAL(PancadaCorporal.class),
    PESADELO(Pesadelo.class),
    PODERDATERRA(PoderDaTerra.class),
    PRESAVENENOSAS(PresaVenenosas.class),
    PUNHODINAMICO(PunhoDinamico.class),
    RAIOPSIQUICO(RaioPsiquico.class),
    RAIOSOLAR(RaioSolar.class),
    RODADECHAMAS(RodaDeChamas.class),
    SOCOFOCADO(SocoFocado.class),
    SURFAR(Surfar.class),
    SUSTO(Susto.class),
    TERREMOTO(Terremoto.class),
    TUMBADEAREIA(TumbaDeAreia.class),
    TUMBADEPEDRA(TumbaDePedra.class),
    VISAODOFUTURO(VisaoDoFuturo.class);

    private final Class<? extends Ataque> ataque;

    ataques(Class<? extends Ataque> ataque) {
      this.ataque = ataque;
    }

    public Class<? extends Ataque> getAtaque(){
      return this.ataque;
    }

  }
  


}
