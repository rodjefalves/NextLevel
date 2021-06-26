# NextLevel

**Obs.:** se preferir ver a apliacação antes da leitura do relatório, pode pular para o fim do documento pois lá encontra-se o passa a passo de execução.

### Título da solução:

Baseado no slogan da empresa: **"It's time to raise the bar"**, batizei a aplicação de NextLevel pois o ingresso na vaga de Jr. representaria um novo nível na minha carreira.

## Detalhes técnicos

### Requisitos:

Elaborei esse documento simplificando de especificação de requisitos para facilitar o planejamento e 

### Arquitetura:

![Arquitetura](URL da imagem)

A arquitetura é simples, consiste em um frontend em React e um back em SpringBoot Java que contem API's REST que são responsáveis pela autenticação de usuários e manipulação dos profiles de profissionais e empresas. Informações sobre empresas, usuários (segurança) e profiles estão separados. Optei por utilizar o H2 DataBase aliado ao Liquibase para geração e alimentação das tabelas ao iniciar a aplicação.

### Estrutura dos principais diretórios:

#### Front-end

![Diretórios do Front](URL da imagem)

- **Components:** diretório dos pequenos componentes que integram as páginas;
- **Pages:** diretório reservados a estrutura de páginas que receberam os componentes;
- **Routes:** diretório onde se localiza a estrutura de rotas da aplicação web.

#### Back-end

![Diretórios do Back](URL da imagem)

- **Components:** diretório dos pequenos componentes que integram as páginas;
- **Pages:** diretório reservados a estrutura de páginas que receberam os componentes;
- **Routes:** diretório onde se localiza a estrutura de rotas da aplicação web.

#### As tabelas

**Foram alimentadas com liquibase.**

![Tabelas](URL da imagem)

O usuário pré-cadastrado para autenticação possui as seguintes credenciais:

**Login:** tony.stark
**Senha:** ironman

No banco de dados a senha é criptografada.

#### Endpoints das API's


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

22/06 - Briefing e planejamento do sistema;
23/06 - Desenvolvimento do "back";
24/06 - Desenvolvimento do front;
25/06 - Entrega da solução e relatório (este documento).


## Problemas encontrados e observações:

- O desenvolvimento do backend ocorreu em algumas horas no primeiro dia do desafio, mas o front, devido a minha falta de prática em React levou mais tempo e infelizmente não foi concluído em tempo hábil;
- O front pode ser executado, mas a Axios só está retornando dados pelo console.log (imagens no anexo I);
- Swagger (utilizada para documentação das API's).

## Como Executar?

### BackEnd:

- No diretório raíz da aplicação.

```console
$ mvn spring-boot:run
```

### FrontEnd:

- No diretório raíz da aplicação.

```console
$ yarn install
```

```console
$ yarn start
```

