# Projeto de Automação Web - Seu Barriga

Este repositório contém um projeto de automação web utilizando **Selenium WebDriver** com **Java**, desenvolvido na **IDE IntelliJ**. Os testes foram escritos seguindo a metodologia **BDD** com o framework **Cucumber**.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação para desenvolvimento da automação.
- **Selenium WebDriver**: Ferramenta para automação de navegadores.
- **Cucumber**: Framework para escrita de testes utilizando BDD.
- **Maven**: Gerenciador de dependências e build.
- **IntelliJ IDEA**: Ambiente de desenvolvimento integrado (IDE).

## Estrutura de Pastas

Abaixo está a estrutura principal do projeto, com a descrição de cada diretório:

```
src/
├── test/
│   ├── java/
│   │   └── base/
│   │   |   └── BasePage.java
│   │   |   └── BasePage.java
│   │   └── pages/
│   │   |   └── HomePage.java
│   │   |   └── RegisterPage.java
│   │   └── runner/
│   │   |   └── RunCucumberTest.java
│   │   └── steps/
│   │   |   └── RegisterSteps.java
│   │   |   └── Hooks.java
│   │   |   └── HomeSteps.java
│   │   └── suporte/
│   │   |   └── BrowserFactory.java
│   └── resources/
│   │   └── features
│   │   |   └── Home.feature
│   │   |   └── Register.feature
│       └── cucumber.properties
```

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- Java JDK (8 ou superior)
- Maven
- IntelliJ IDEA
- Google Chrome (ou outro navegador compatível)
- ChromeDriver (ou o WebDriver correspondente ao navegador escolhido)

## Como Executar os Testes

1. Clone este repositório:
   
   ```bash
   git clone https://github.com/CristianoSFMothe/seu-barriga-selenium.git
   cd seu-barriga-selenium
   ```

3. Atualize as dependências do projeto com o Maven:
   
   ```bash
   mvn clean install
   ```

4. Execute os testes utilizando o Maven:

   ```bash
   mvn test
   ```

5. Os relatórios dos testes serão gerados automaticamente na pasta `target`.

## Funcionalidades Automizadas

Atualmente, o projeto cobre as seguintes funcionalidades do site **Seu Barriga**:

- Acesso à página inicial.
- Cadastro de novos usuários.
- Outros cenários podem ser implementados conforme a necessidade.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests para melhorias.

## Licença

Este projeto é distribuído sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## Desenvolvedor:

### <a href="https://portfolio-qa-cristiano.vercel.app/">Cristiano SFMothe</a>  

---

### Configura dos arquivos principais

#### Classe BasePage

A classe `BasePage.java` é uma classe base que centraliza métodos comuns de interação com a página, proporcionando uma abstração para facilitar a automação de testes. Ela estende a classe `BrowserFactory` e oferece métodos reutilizáveis para interagir com os elementos da página de forma mais eficiente. 

<details><summary>java/base/BasePage</summary>

- **`visitPage(String url)`**:  
  Acessa a URL fornecida no navegador.

- **`click(By locator)`**:  
  Realiza um clique em um elemento localizado pelo seletor `By`.

- **`pressEnter()`**:  
  Simula o pressionamento da tecla `ENTER` no navegador.

- **`fill(By locator, String texto)`**:  
  Preenche um campo de texto localizado por um `By` com o texto fornecido, limpando o campo antes.

- **`waitElementVisible(By element, int seconds)`**:  
  Aguarda até que um elemento especificado esteja visível na página, com tempo de espera configurável.

- **`getValueByText(By locator)`**:  
  Retorna o texto de um elemento localizado por um `By`.

- **`getCurrentUrl()`**:  
  Retorna a URL atual da página carregada no navegador.

#### Benefícios da Classe BasePage

A `BasePage` ajuda a evitar a repetição de código, centralizando funcionalidades comuns de interação com a página. Ao utilizar esta classe, torna-se possível alterar a lógica de interação em um único lugar, tornando o código mais fácil de manter e expandir. Além disso, facilita a leitura e a organização dos testes, tornando-os mais claros e concisos.

Essa abordagem segue o princípio da **reutilização de código**, melhorando a manutenção e escalabilidade da automação de testes.

</details>

---


### Classe BaseSteps

A classe `BaseSteps.java` fornece métodos utilitários que são usados durante a execução dos testes, incluindo a inicialização e o encerramento do navegador, bem como a captura de screenshots em caso de falha ou para registros visuais dos testes. Ela estende a classe `BrowserFactory` e contém métodos utilizados no ciclo de vida dos testes, como abrir e fechar o navegador, e gerar capturas de tela para inspeção posterior.

<details><summary>java/base/BaseSteps</summary>

- **`OpenBrowser()`**:  
  Método responsável por iniciar o navegador, verificando se a instância do `WebDriver` ainda não foi criada. Ele garante que o navegador só seja iniciado uma vez por execução.

- **`CloseBrowser()`**:  
  Método que finaliza o navegador, garantindo que o processo do `WebDriver` seja fechado corretamente após o término dos testes, prevenindo vazamentos de recursos.

- **`screenshot()`**:  
  Método para tirar uma captura de tela da página atual durante o teste. A imagem é gerada e anexada ao relatório do Cucumber, incluindo um timestamp no nome do arquivo para identificar de forma única cada screenshot. Isso é útil para análise e depuração dos testes.

#### Benefícios da Classe `BaseSteps`

A classe `BaseSteps` centraliza o controle do ciclo de vida do navegador (abertura e fechamento) e o processo de captura de imagens, o que facilita o monitoramento do estado da aplicação durante os testes. A captura de screenshots após a execução de cada teste é uma boa prática para validar o comportamento da aplicação, especialmente em testes de UI, onde as falhas podem ser difíceis de reproduzir.

Além disso, o uso de uma única instância para o navegador e a captura de screenshots auxilia na organização e rastreamento dos testes, proporcionando maior clareza e controle durante a execução do Cucumber.

</details>

---

### Classe RunCucumberTest

A classe `RunCucumberTest.java` é responsável por configurar a execução dos testes automatizados utilizando o Cucumber com JUnit. Ela define as opções para a execução do Cucumber e configura o ciclo de vida dos testes, incluindo a geração de relatórios e a inicialização e finalização do navegador. A classe utiliza as anotações do JUnit para configurar as ações antes e após a execução dos testes.

<details><summary>java/runner/RunCucumber</summary>

- **`@RunWith(Cucumber.class)`**:  
  A anotação `@RunWith` informa ao JUnit que a classe deve ser executada com o Cucumber, possibilitando a execução dos testes definidos nos arquivos `.feature`.

- **`@CucumberOptions`**:  
  Configura as opções do Cucumber para o teste. As principais configurações incluem:
  - **`tags`**: Define as tags de cenários a serem executados. No exemplo, os testes com a tag `@Register` são executados.
  - **`features`**: Define o caminho para os arquivos `.feature` contendo os cenários de teste.
  - **`glue`**: Define o pacote onde as definições de steps (implementações de ações) estão localizadas.
  - **`monochrome`**: Define se a saída do terminal será colorida ou não (padrão: `false`).
  - **`snippets`**: Define o estilo dos métodos gerados para os steps no código (neste caso, `CAMELCASE`).
  - **`dryRun`**: Permite validar os steps sem executar o teste (padrão: `false`).
  - **`plugin`**: Configura os plugins para geração de relatórios, como `pretty`, `html` e `json`.

#### Métodos da Classe `RunCucumberTest`

- **`BeforeAllTest()`**:  
  Método executado antes de todos os testes, responsável por abrir o navegador utilizando o método `OpenBrowser()` da classe `BaseSteps`.

- **`AfterAllTest()`**:  
  Método executado após todos os testes, responsável por gerar um relatório detalhado dos testes utilizando o `ReportBuilder`. O relatório é gerado em formato HTML e JSON, com informações adicionais como data, ambiente, URL e outros detalhes sobre a execução.

#### Benefícios da Classe `RunCucumberTest`

A classe `RunCucumberTest` centraliza a configuração e o gerenciamento da execução dos testes. Ela facilita a execução do Cucumber, configurando os caminhos para os arquivos de features e steps, além de gerar relatórios automáticos de forma estruturada após os testes. Isso permite uma análise mais detalhada da execução dos testes, proporcionando insights sobre o ambiente, o tempo de execução e os resultados dos testes.

A integração com o `ReportBuilder` permite criar relatórios visuais personalizados, que podem ser úteis para a análise e comunicação dos resultados com a equipe.

</details>

---

### Classe Hooks

A classe `Hooks.java` gerencia os métodos que são executados antes e depois de cada cenário de teste, utilizando as anotações `@Before` e `@After` do Cucumber. Ela é responsável por configurar o cenário e garantir que ações como captura de screenshots e o fechamento do navegador sejam realizadas de maneira eficiente.

<details><summary>java/steps/Hooks</summary>

- **`BeforeAllScenario(Scenario _scenario)`**:  
  Método executado antes de cada cenário de teste. Ele armazena a instância do cenário, permitindo acessar informações sobre o status do teste, como se ele falhou ou não.

- **`AfterAllScenario()`**:  
  Método executado após cada cenário de teste. Se o cenário falhar, ele chama o método `screenshot()` para capturar uma imagem da página no momento da falha. Além disso, garante que o navegador seja fechado após o teste, caso a variável `closeBrowser` esteja configurada para `true`.

#### Benefícios da Classe `Hooks`

A classe `Hooks` automatiza a execução de tarefas antes e após os cenários de teste, como captura de imagens de falhas e o gerenciamento do ciclo de vida do navegador. Isso facilita a manutenção do código de testes, evitando a repetição de código e garantindo que as tarefas essenciais (como capturar screenshots em caso de falha e fechar o navegador) sejam sempre executadas corretamente. Além disso, ao associar o cenário com a execução dos hooks, a classe proporciona um controle mais preciso sobre o comportamento dos testes durante sua execução.


</details>

---

### Classe BrowserFactory

A classe `BrowserFactory.java` é responsável pela criação e gerenciamento da instância do navegador utilizada nos testes automatizados. Ela utiliza o WebDriverManager para gerenciar os drivers dos navegadores e oferece suporte a diferentes navegadores, como Google Chrome e Firefox, tanto em modo padrão quanto headless (sem interface gráfica).

<details><summary>java/support/BrowserFactory</summary>

- **`getBrowser()`**:  
  Método que retorna a instância do navegador. Caso ainda não tenha sido inicializada, ele cria uma nova instância com o navegador Chrome por padrão.

- **`getBrowser(Browser nav)`**:  
  Método responsável por criar a instância do navegador com base no tipo especificado (Chrome ou Firefox, em suas versões headless ou com interface). Ele configura as opções específicas de cada navegador e inicializa o driver correspondente.

- **`createChromeOptions()`**:  
  Método que configura as opções específicas do navegador Google Chrome, como a definição do idioma, a desativação de notificações, a configuração do tamanho da janela e outras opções para otimizar a execução dos testes.

- **`createFirefoxOptions()`**:  
  Método que configura as opções específicas do navegador Firefox, incluindo a desativação de extensões.

- **`killDriver()`**:  
  Método que finaliza a instância do navegador e limpa o objeto `driver` para liberar recursos ao final da execução do teste.

#### Benefícios da Classe `BrowserFactory`

A classe `BrowserFactory` centraliza a criação e o controle dos navegadores utilizados nos testes, permitindo fácil configuração e troca entre diferentes opções de navegadores e modos de execução. O uso do WebDriverManager garante que os drivers corretos sejam baixados e configurados automaticamente, sem a necessidade de configurações manuais.

Além disso, a possibilidade de utilizar os navegadores em modo headless (sem interface gráfica) facilita a execução dos testes em ambientes de integração contínua (CI), como Jenkins, sem necessidade de uma interface de usuário. A centralização da criação do navegador também contribui para um código mais limpo e reutilizável, mantendo o foco nas lógicas de teste em vez de na configuração do ambiente de execução.

</details>

---

### Arquivo cucumber.properties

O arquivo `cucumber.properties` contém configurações específicas para a execução dos testes do Cucumber. Ele permite ajustar o comportamento do Cucumber durante a execução, como a forma de exibir logs ou relatórios.

<details><summary>java/support/BrowserFactory</summary>

- **`cucumber.publish.quiet=true`**:  
  Esta configuração desativa a publicação de informações detalhadas sobre a execução dos testes no console. Ao definir essa propriedade como `true`, as saídas de log serão mais silenciosas, o que pode ser útil para reduzir o ruído nas saídas de execução, especialmente em ambientes de integração contínua (CI).

#### Benefícios do Arquivo `cucumber.properties`

O uso do arquivo `cucumber.properties` oferece uma maneira prática de personalizar a execução do Cucumber sem modificar diretamente o código-fonte. Isso facilita a configuração e o controle das opções de execução, permitindo ajustes finos na geração de relatórios e na visibilidade das saídas, conforme a necessidade do projeto.

</details>


