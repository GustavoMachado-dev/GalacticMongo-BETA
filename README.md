
# GalacticMongo-BETA

**GalacticMongo-BETA** é uma API desenvolvida com foco em estudos de requisições, documentação de APIs, padrões de projeto e bancos de dados não-relacionais. Esta API utiliza a integração com o sistema de HelpDesk "Tom Ticket" como base de estudo, aplicando princípios de arquitetura limpa e boas práticas de engenharia de software para criar uma aplicação robusta e escalável.

## Funcionalidades

- **Requisições API**: Realização de requisições eficientes para o sistema de HelpDesk "Tom Ticket".
- **Documentação**: Uso de Swagger para documentação automática, visando facilitar a compreensão e o uso da API.
- **Padrões de Projeto**: Aplicação de padrões de design para garantir flexibilidade e manutenção do código.
- **Banco de Dados Não-Relacional**: Integração com MongoDB para armazenamento e gerenciamento de dados.
- **Arquitetura Limpa**: Organização modular da aplicação, promovendo a separação de responsabilidades.

## Requisitos

Antes de iniciar, certifique-se de ter instalado em sua máquina:

- **Java 17+**: A API é desenvolvida em Java, então essa versão é necessária.
- **Maven**: Para gerenciamento de dependências.
- **MongoDB**: A aplicação utiliza um banco de dados MongoDB para armazenamento.
- **Tom Ticket API**: Credenciais e endpoints da API do sistema "Tom Ticket".

## Instalação

1. Clone o repositório em sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/GalacticMongo-BETA.git
   ```

2. Acesse o diretório da aplicação:
   ```bash
   cd GalacticMongo-BETA
   ```

3. Carregue as dependências Maven:
   ```bash
   mvn clean install
   ```

4. Configure o serviço SMTP e MongoDB:
   - Acesse o arquivo `application.properties` na pasta abaixo e configure o serviço SMTP do seu email para enviar logs, além da string de conexão com o MongoDB:
   ```bash
   cd TomTicket-api1/src/main/resources
   ```
   - Insira as seguintes configurações no arquivo `application.properties`:
   ```properties
   spring.mail.host=smtp.seuemail.com
   spring.mail.username=seuemail@exemplo.com
   spring.mail.password=suasenha
   spring.mail.port=587
   spring.data.mongodb.uri=mongodb://localhost:27017/galacticmongo
   ```

5. Configure o envio de logs por email:
   - Acesse o arquivo `MailConfig.java` para configurar o envio de logs:
   ```bash
   cd TomTicket-api1/src/.../structure/infraestructure/config
   ```

6. Configure seu token de acesso à API do Tom Ticket:
   - Acesse o arquivo `TomToken` na pasta abaixo e insira o token da API:
   ```bash
   cd TomTicket-api1/src/.../structure/infraestructure/config
   ```
   - Exemplo:
   ```java
   public class TomToken {
       public static final String TOKEN = "seu_token";
   }
   ```

7. Configure as collections do MongoDB:
   - Acesse o diretório abaixo para configurar as collections que irão salvar seus dados:
   ```bash
   cd TomTicket-api1/src/.../structure/infraestructure/mongo/repositories
   ```

## Inicialização

1. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

2. Acesse o Swagger para a documentação da API:
   ```
   http://localhost:8080/swagger-ui.html
   ```

---

## Contato

Você pode me seguir no [LinkedIn](https://www.linkedin.com/in/gustavomachado-dev/) ou entrar em contato por e-mail:

- gustavof.docentemachado@gmail.com
- gustavo.lopes04@edu.pucrs.br
