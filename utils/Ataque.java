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