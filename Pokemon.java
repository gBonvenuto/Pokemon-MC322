import java.util.ArrayList;
import java.util.Scanner;

import utils.*;


public class Pokemon {


    // iniciando a classe pokemon

    // variáveis 
    String nome;
    int vida = 100; // todos os pokemons iniciam com 100 de vida

    // vraiáveis espciais
    Tipo tipo;  // todo pokemon possui um tipo espcífico --> apenas um por pokemon

    Ataque ataque;// todo pokemon pode atacar

    ArrayList<Ataque> ataques = new ArrayList<>();

    Defesa defesa; // todo pokemon pode se defender

    public Pokemon(String nome, Tipo tipo){
        this.nome = nome;
        this.tipo = tipo;
    }


    // métodos implementação

    public int getVida(){
        return this.vida; 
    }

    public String getNome(){
        return this.nome;
    }

    public Tipo getTipo(){
        return this.tipo;
    }





    // método de atacar
    public int ataca(Pokemon pokemon){ 
        // deve escolher o ataque --> é bom que isso seja uma subescolha de um menu de ações
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha o ataque"); // suponho que exista uma função getNomeAtaque

        int i = 0;
        int dano;
        for (Ataque at: ataques){
            i++;
            System.out.println(i + at.getNomeAtaque);
        }
        
        int escolha = sc.nextInt();

        do {
            System.out.println("Escolha um número de 1 a 4:");
            while (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, insira um número."); // resolve se o usuário inserir nada
                sc.next(); // Limpar entrada inválida
            }

            escolha = sc.nextInt();

            dano = switch (escolha) {
                case 1 -> ataques.get(0).getDano();  // suponho a existência de um método getDano na classe Ataque
                    
                case 2 -> ataques.get(1).getDano();
            
                case 3 -> ataques.get(2).getDano();
                    
                case 4 -> ataques.get(3).getDano();
                    
                default -> -1;
                  // TODO: printar a seguinte mensagem se retornar -1
                  // System.out.println("Escolha inválida. Por favor, insira um número entre 1 e 4.");
            };

        } while (escolha < 1 || escolha > 4); // restringe a escolha do usuário

        sc.close();

    }

    public void defender(Pokemon pokemon, int dano){ // na função de lógica de jogo eu vou ter que lembrar disso ( associar o ataque de um pokemon ao outro)
        
        // a função de defesa tem que considerar o tipo do atcante e do meu pokemon
        Tipo tipoAdversário = pokemon.getTipo();

        // puxar os métodos de defesa da classe tipo
        this.tipo.defesa(tipoAdversário);
    }



}
