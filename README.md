# Pokemon-MC322 V-1.0
Projeto de pokemon no Terminal para a disciplina de MC322
## Descrição do projeto
### O Projeto é composto algumas pastas como utils, ataques e tipos:
- Na pasta de **utils** nós temos a declaração dos arquivos **Ataque.java** e **Tipo.java** que servem de base para a construção dos Pokemos e dos Ataques dos Pokemons;
- Obs: O arquivo de tipo vai ser uma classe abstrata, enquanto o arquivo de Ataques é uma classe mãe normal;
- Na pasta de **Ataques** nós temos uma coletânea de alguns ataques que serão, mais tarde atribuídos à cada pokemon de forma totalmente aleatória levando em consideração o seu tipo;
- Na pasta de **tipos** nós vamos ter uma coletânea dos tipos mais famosos de pokemons, da primeira geração, levando em consideração as suas fraquezas, vantagens e eventuais imunidades;

### Fora das pastas:
- Fora das pastas nós temos os arquivos:
- **Jogador**: Vai possuir, no seu contrutor a inicialização de um jogador, e no corpo do código algumas funções para o funcionamento da classe, tais como escolha do pokemon;
- **Pokemon**: A classe pokemon vai possuir as funções necessárias para a manipulação e insstanciação de um pokemon ao time do jogador e funcionamento em uma futura batalha;
- Alguns exemplos de funções importantes são a função de ataque e defesa, a função ataque vai retornar um valor int do dano, enquanto a função defesa vai receber esse valor como argumento e, juntamente do tipo do pokemon, fazer o cálculo do que vai ser realmente retirado da vida total do pokemon;
- obs: Na classe pokemon vamos ter um enum de exatamente 30 pokemons que poderão ser adicionados ao time do jogador (MAX = 4);

### Para a próxima versão:
- Início da lógica de jogo;
- implementação de um servidor para possibilitar interação multiplayer;
- organização da seleção de ataques de forma aleatória baseada em matchmaking com os tipos dos pokemon; 
