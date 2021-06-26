# NextLevel

**Obs.:** se preferir ver a apliacação antes da leitura do relatório, pode pular para o fim do documento pois lá encontra-se o passa a passo de execução.

### Título da solução:

Baseado no slogan da empresa: **"It's time to raise the bar"**, batizei a aplicação de NextLevel pois o ingresso na vaga de Jr. representaria um novo nível na minha carreira.

## Detalhes técnicos

### Arquitetura:

![Arquitetura](URL da imagem)

A arquitetura é simples, consiste em um frontend em React e um back em SpringBoot Java que contem API's REST que são responsáveis pela autenticação de usuários e manipulação dos profiles de profissionais e empresas. Informações sobre empresas, usuários (segurança) e profiles estão separados. Optei por utilizar o H2 DataBase aliado ao Liquibase para geração e alimentação das tabelas ao iniciar a aplicação.

### Estrutura dos principais diretórios:

#### Front-end

- **Components:** diretório dos pequenos componentes que integram as páginas;
- **Pages:** diretório reservados a estrutura de páginas que receberam os componentes;


#### Back-end

- **Config:** aqui se localiza as configurações do security e do swagger;
- **Entity:** diretório reservado para as entidades que fazem parte do back (Empresas, Profiles e Usuários);
- **Exceptions:** aqui existem duas exceptions: profile não encontrado e senha inválida;
- **Repository:** repositórios JPA das 3 entidades do back;
- **Rest:** aqui encontra-se os controllers e DTO's utilizados nas requisições REST;
- **Security:** configurações de autenticação e JWT;
- **Service:** onde estão as poucas regras de negócio da aplicação.

#### Endpoints das API's

![Endpoints](URL da imagem)

### Tecnologias utilizadas:

- SpringBoot (Backend em Java);
- ReactJS e Material UI (Frontend em Javascript);
- Liquibase (utilizado para geração e alimentação autônoma das tabelas de empresas, usuários e profiles);
- Swagger (utilizada para documentação das API's);
- Spring Security (autenticação simples com geração de TOKEN JWT);
- H2 DataBase (banco em memória para ).
- RabbitMQ (Message Broker).


## Cronograma:

O cronograma abaixo foi definido no primeiro dia do desafio.

- 22/06 - Briefing e planejamento do sistema;
- 23/06 - Desenvolvimento do "back";
- 24/06 - Desenvolvimento do front;
- 25/06 - Entrega da solução e relatório (este documento).


## Problemas encontrados e observações:

- O desenvolvimento do backend ocorreu em algumas horas no primeiro dia do desafio, mas o front, devido a minha falta de prática em React levou mais tempo e infelizmente não foi concluído em tempo hábil;
- O front pode ser executado, mas a Axios só está retornando dados pelo console.log (imagens no anexo I);
- Swagger (utilizada para documentação das API's).

## Como Executar?

O usuário pré-cadastrado para autenticação possui as seguintes credenciais:

**Login:** tony.stark
**Senha:** ironman

### BackEnd:

- No diretório raíz da aplicação.

```console
$ mvn spring-boot:run
```

Para acessar a documentação no Swagger e fazer testes na API:

- [Swagger UI](http://localhost:8081/swagger-ui.html)

**1º Passo:** autenticar usuário e senha no endpoint para gerar token (tony.stark e ironman);
**2º Passo:** copiar token e add Bearer antes, para testar quanlquer outro endpoint;
**3° Passo:** colar no botão de eutenticação no lado direito da aplicação.

### FrontEnd:

- No diretório raíz da aplicação.

```console
$ yarn install
```

```console
$ yarn start
```

No front, não consegui manipular o Dom do React para recuperar o login e senha, então a Axios só está funcionando em hardcoded, mas vou corrigir durante o fim de semana.

