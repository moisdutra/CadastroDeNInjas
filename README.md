# Cadastro de Ninjas

Uma API REST para gerenciamento de ninjas (CRUD completo: criar, ler, atualizar e deletar), desenvolvida com **Spring Boot** e Java. 
Este projeto faz parte do curso **Java10x** (www.java10x.dev), onde aplico conceitos de backend como modelagem de banco de dados, endpoints REST e integração com SQL.

## Funcionalidades
- Cadastro de ninjas com nome, idade, email e rank.
- Atribuição de missões a ninjas (relação um-para-muitos).
- Operações CRUD via API endpoints (ex: `/ninjas`, `/ninjas/{id}`).
- Integração com banco de dados relacional (ex: H2 ou PostgreSQL).

## Tecnologias
- Java + Spring Boot
- Spring Data JPA
- Banco de dados SQL
- Maven/Gradle para build

## Como Executar
1. Clone o repositório: `git clone https://github.com/moisdutra/CadastroDeNInjas.git`
2. Entre na pasta: `cd CadastroDeNInjas`
3. Build: `mvn clean install`
4. Rode: `mvn spring-boot:run`
5. Acesse: [http://localhost:8080](http://localhost:8080) (Swagger ou H2 Console se configurado).

## Curso
Projeto prático do **Java10x**, focado em desenvolvimento backend com exemplos de Naruto.
