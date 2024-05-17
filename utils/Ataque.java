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