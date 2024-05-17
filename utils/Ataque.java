package utils;
public class Ataque {

    private String nome;
    private int dano;
    private Class<Tipo> tipo;
    
    public Ataque(String nome, int dano, Class<Tipo> tipo){
        this.nome = nome;
        this.dano = dano;
        this.tipo = tipo;
    }

    public String getNome() {
      return this.nome;
    }
    public void setNome(String value) {
      this.nome = value;
    }

    public int getDano() {
      return this.dano;
    }
    public void setDano(int value) {
      this.dano = value;
    }

    public Class<Tipo> getTipo() {
      return this.tipo;
    }
    public void setTipo(Class<Tipo> value) {
      this.tipo = value;
    }


    public static void atacar(Ataque ataque){

    }

    /*checklist dos tipos e ataques:
     * normal (4/4)
     * água (4/4)
     * fogo (4/4)
     * planta (4/4)
     * inseto (4/4)
     * veneno (4/4)
     * pedra (4/4)
     * terra (4/4)
     * lutador (4/4)
     * fantasma (4/4)
     * psíquico (4/4)
     * dragão (2/4)
     * voador (0/4)
     * elétrico (0/4)
     * gelo (0/4)
     */

    
}