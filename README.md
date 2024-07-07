Grupo: 

- Giancarlo Bonvenuto - 248527
- Thiago Augusto de Tulio Nascimento - 252937
- Pedro Henrique dos Reis Arcoverde - 254719
- Pedro Henrique Pinheiro Linhares - 175807

![WhatsApp Image 2024-07-07 at 09 08 23](https://github.com/gBonvenuto/Pokemon-MC322/assets/141372403/8489d63f-5feb-4038-aff2-c631caaf2e99)

# Como executar

Primeiro clone o repositório:

`git clone https://github.com/gBonvenuto/Pokemon-MC322`

Em seguida compile os arquivo:

`javac -d bin -sourcepath src src/main/java/main/Main.java src/main/java/utils/* src/main/java/tipos/* src/main/java/ataques/*`

E então rode o jogo

`java -cp bin/ main.Main`

# Pokemon-MC322 V-1.0
Projeto de pokemon no Terminal para a disciplina de MC322
## Descrição do projeto

### O Projeto é composto algumas pastas como utils, ataques e tipos:
- Na pasta de **utils** nós temos a declaração dos arquivos **Ataque.java**, **Tipo.java**, **Jogador.java**, **Pokemon.java**, **Servidor.java** e **Jogo.java** que servem de base para a construção dos Pokemons e dos Ataques dos Pokemons;
- Obs: O arquivo de tipo vai ser uma classe abstrata, enquanto o arquivo de Ataques é uma classe mãe normal;
- Na pasta de **Ataques** nós temos uma coletânea de alguns ataques que serão, mais tarde atribuídos à cada pokemon de forma totalmente aleatória levando em consideração o seu tipo;
- Na pasta de **tipos** nós vamos ter uma coletânea dos tipos mais famosos de pokemons, da primeira geração, levando em consideração as suas fraquezas, vantagens e eventuais imunidades;
- **Pokemon**: A classe pokemon vai possuir as funções necessárias para a manipulação e instanciação de um pokemon ao time do jogador e funcionamento em uma futura batalha; Alguns exemplos de funções importantes são a função de ataque e defesa, a função ataque vai retornar um valor int do dano, enquanto a função defesa vai receber esse valor como argumento e, juntamente do tipo do pokemon, fazer o cálculo do que vai ser realmente retirado da vida total do pokemon;

#Pokemon-MC322 V-1.0
- Realizamos algumas mudanças na segunda parte do projeto, entre elas podemos incluir:
1. Inserção de interface interativa utilizando a biblioteca swing do java. Para isso 4 novos arquivos (Panel do jogador, Painel da batalha, Interface de escolha do pokemon e uma interface para escolha do arquivo de logs).
2. Inserção de um sistema de salvamento de logs, também foi incluido na interface, com devido tratamento de erro. Para isso temos 1 novo arquivo ( arquivo SaveLog).
3. Adapetação da classe de Jogo, que inclui a lógica de jogo para ser usada na interface e não mais como terminal.
4. O cálculo do dano a ser recebido com o ataque foi retirado da função defesa e implementado na função de ataque.
5. Finalização e testagem do jogo foram realizadas, o projeto funciona tanto para Linux como para Windows.
