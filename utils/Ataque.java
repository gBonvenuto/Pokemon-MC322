package utils;
public class Ataque {

    private String nome;
    private int dano;
    private Tipo tipo;
    
    public Ataque(String nome, int dano, Tipo tipo){
        this.nome = nome;
        this.dano = dano;
        this.tipo = tipo;
    }

    public static void atacar(Ataque ataque){

    }

    /*checklist dos tipos e ataques:
     * normal (0/4)
     * água (0/4)
     * fogo (0/4)
     * planta (0/4)
     * inseto (0/4)
     * venenoso (0/4)
     * pedra (0/4)
     * terra (0/4)
     * lutador (0/4)
     * fantasma (0/4)
     * psíquico (0/4)
     * dragão (0/4)
     * voador (0/4)
     * elétrico (0/4)
     * gelo (0/4)
     */
}