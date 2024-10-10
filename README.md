### Projeto Pacotinho do Amor v2 🐾

Este projeto evoluiu para uma versão mais robusta e modular, mantendo o propósito original de gerenciar um programa 100% voluntário de adoção de cachorros e gatos abandonados ou resgatados, mas agora seguindo os princípios de Clean Architecture para garantir escalabilidade e manutenção mais eficiente.

#### Backend

O backend da aplicação continua sendo desenvolvido em **Java 17** utilizando o framework **Spring Boot**, garantindo ainda mais eficiência e robustez. A segurança é aprimorada com o uso de **JWT** em conjunto com o **Spring Security** para uma autenticação moderna e segura.

O banco de dados adotado permanece o **MySQL**, sendo manipulado via **JPA**, e agora as camadas de repositório seguem o padrão de repositórios limpos, facilitando a substituição e a modularidade dos dados.

#### Arquitetura Clean

Nesta nova versão, adotamos o conceito de **Clean Architecture**, que oferece uma separação clara entre as responsabilidades, garantindo uma maior testabilidade e flexibilidade no crescimento do sistema. O código agora é estruturado em camadas como:

- **Controllers**: Para lidar com as requisições HTTP e chamadas de casos de uso.
- **Use Cases**: Onde reside a lógica de negócios.
- **Repositories**: Para a persistência e manipulação dos dados.
- **Entities**: Definindo as regras de negócio essenciais.

#### Como Rodar o Projeto Localmente:

1. Clone o projeto em sua máquina e abra-o em sua IDE preferida.
2. Baixe todas as dependências necessárias (em IDEs como o IntelliJ, basta clicar no botão de baixar as dependências).
3. Certifique-se de ter o MySQL Workbench instalado em sua máquina e crie um banco chamado `ainda-nao-definido ----`.
4. No arquivo `application.properties`, ajuste ou insira as credenciais e a URL do seu banco de dados.
5. Execute o projeto a partir da classe principal.
6. Para testar as APIs no Postman, faça login com um usuário previamente criado para obter o token JWT e incluir nas requisições.

#### Novas Funcionalidades

- **Autenticação via JWT**: Agora as requisições exigem tokens para maior segurança.
- **Camadas Modulares**: O código foi reestruturado com o objetivo de ser mais legível e de fácil manutenção.
- **Atualização para Java 17**: Aproveitando as novas funcionalidades e melhorias de performance da versão.

#### Tecnologias Utilizadas:

- **Java 17**
- **Docker**
- **MySQL**
- **Spring Boot**
- **Spring Security com JWT**
- **JPA**
- **Clean Architecture**
- **JUnit** (para testes unitários)

*Se você pretende utilizar este projeto profissionalmente ou para estudos, ficarei muito feliz em receber créditos ou até mesmo uma simples mensagem de reconhecimento pelo meu trabalho! Obrigado!*
