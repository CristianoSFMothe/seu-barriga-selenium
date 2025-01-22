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

**Desenvolvedor:** Cristiano SFMothe  
```
