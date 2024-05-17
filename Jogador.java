import java.util.Scanner;

class Jogador {
  private String nome;
  private Pokemon[] pokemons = new Pokemon[4]; // Cada jogador terá somente 4 pokemons
  private List<Item> itens = new ArrayList<Item>();

  Jogador(String nome) {
    this.nome = nome;
  }

  public void SelecionarPokemons(){
    boolean pokemon_valido = false;
    String pokemon_escolhido;
    for(int i = 0; i<pokemons.length; i++){
      pokemon_valido = false;
      Scanner scanner = new Scanner(System.in);
      System.out.println(Pokemon.lista);
      do{
        System.out.println("Digite o nome do pokemon que você deseja escolher");
        pokemon_escolhido = scanner.next();
        if (Class.forName(pokemon_escolhido) != null) {
          pokemon_valido = true;
        }
        else{
          System.out.println("Não foi possível encontrar este pokemon, tente outro");
        }
      }while(pokemon_valido);
      
      pokemons[i] = Class.forName(pokemon_escolhido);
  }

}
