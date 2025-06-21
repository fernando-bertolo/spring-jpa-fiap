# TalkEvents - Sistema de Gerenciamento de Eventos

## 📋 Sobre o Projeto

Este é um projeto de estudos desenvolvido durante a **Fase 2** da Pós-Graduação em **Arquitetura e Desenvolvimento Java**, com foco no aprendizado e aplicação prática do **Spring JPA** e tecnologias relacionadas.

O TalkEvents é um sistema para gerenciamento de eventos e sessões, implementado com Spring Boot e banco de dados MySQL, demonstrando conceitos fundamentais de:

- Mapeamento Objeto-Relacional (ORM) com JPA/Hibernate
- Relacionamentos entre entidades
- Configuração de DataSource
- Containerização com Docker

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Spring Boot** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Hibernate** - Implementação JPA
- **MySQL 8.0** - Banco de dados
- **Docker & Docker Compose** - Containerização
- **Maven** - Gerenciamento de dependências

## 🏗️ Arquitetura do Projeto

```
src/
├── main/
│   ├── java/org/talkevents/talkevents/
│   │   ├── entities/          # Entidades JPA
│   │   │   └── Event.java     # Entidade Event com relacionamentos
│   │   └── TalkeventsApplication.java
│   └── resources/
│       └── application.properties  # Configurações da aplicação
├── docker-compose.yml         # Configuração do MySQL
└── README.md
```

## 🛠️ Configuração e Execução

### Pré-requisitos

- Java 17+
- Maven 3.6+
- Docker e Docker Compose

### 1. Clone o repositório

```bash
git clone <url-do-repositorio>
cd talkevents
```

### 2. Inicie o banco de dados MySQL

```bash
docker-compose up -d mysql
```

### 3. Aguarde o MySQL inicializar

```bash
docker-compose logs -f mysql
```

Aguarde até ver a mensagem: `ready for connections`

### 4. Execute a aplicação

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## 🗄️ Configuração do Banco de Dados

### Credenciais MySQL (Docker)
- **Host**: localhost:3306
- **Database**: talkevents
- **Usuário**: bertolo
- **Senha**: bertolo123
- **Root Password**: root123

### Configurações JPA
- **DDL Auto**: update (cria/atualiza tabelas automaticamente)
- **Show SQL**: habilitado para debug
- **Fetch Strategy**: LAZY para otimização de performance

## 📊 Modelo de Dados

### Entidade Event
- Relacionamento `@OneToMany` com Session
- Configuração `@JsonProperty(WRITE_ONLY)` para evitar referências circulares
- Uso de `Set<Session>` para garantir unicidade

## 🎯 Objetivos de Aprendizado

Este projeto demonstra os seguintes conceitos do Spring JPA:

- [x] Configuração de DataSource com MySQL
- [x] Mapeamento de entidades com anotações JPA
- [x] Relacionamentos bidirecionais (@OneToMany/@ManyToOne)
- [x] Estratégias de fetch (LAZY/EAGER)
- [x] Controle de serialização JSON
- [x] Uso de Collections (Set) em relacionamentos
- [x] Configuração de pool de conexões (HikariCP)
- [x] DDL automático com Hibernate

## 🐳 Docker

O projeto utiliza Docker Compose para facilitar o setup do ambiente de desenvolvimento:

```yaml
# docker-compose.yml
services:
  mysql:
    image: mysql:8.0
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root123
      MYSQL_DATABASE: talkevents
      MYSQL_USER: bertolo
      MYSQL_PASSWORD: bertolo123
```
