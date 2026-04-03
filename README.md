# GamerClub

Este projeto demonstra a refatoração do projeto `alugames` (originalmente em Kotlin) para o ecossistema Java, adotando a arquitetura baseada no `ProjetoAPIs`. A aplicação consome a API externa [CheapShark](https://apidocs.cheapshark.com/).

## Estrutura do Projeto

A estrutura de pacotes principal localiza-se em `src/main/java/br/com/fiap/gamescom/` e está dividida em:

- **api**: Contém os modelos de dados da aplicação (`Gamer`, `Jogo`, `InfoJogo`, `InfoAPIShark`). 
- **services**: Contém a classe `ConsumoAPIService`, responsável por realizar requisições HTTP (GET) para a API utilizando a biblioteca Apache HttpClient e conversão JSON com `Gson`.
- **main**: Contém classes para execução (ponto de entrada) da aplicação:
  - `TesteGamer`: Script interativo completo que possibilita criar uma conta de usuário com interações gráficas via `JOptionPane`, realizar buscas de jogos via API, adicionar descrições, além de listar, filtrar e apagar procuras antigas.
  - `TesteAPI`: Script focado única e exclusivamente para testar de maneira rápida se a comunicação e consumo da API da CheapShark estão íntegros e funcionais.

## Tecnologias Utilizadas

- **Java 17**
- **Maven** (Gerenciador de dependências)
- **Apache HttpClient** (Para requisições HTTP)
- **Google Gson** (Para desserialização de objetos JSON)
- **Swing / JOptionPane** (Para interações gráficas e input do usuário)

## Como Rodar

1. Certifique-se de que tenha o JDK devidamente configurado, bem como o Maven.
2. No diretório raiz do repositório, execute a compilação:
   ```bash
   mvn compile
   ```
3. Você pode usar a sua IDE de preferência (como IntelliJ IDEA, Eclipse ou VS Code) bastando importar o diretório como um projeto Maven, em seguida:
   - Para interagir com toda a aplicação (cadastro de usuário, coleções de jogo, etc), rode o arquivo principal:
     `br.com.fiap.gamescom.main.TesteGamer`
   - Caso queira apenas testar a funcionalidade de buscar um jogo em específico por ID, execute a classe:
     `br.com.fiap.gamescom.main.TesteAPI`
