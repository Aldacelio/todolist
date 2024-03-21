<h1 align="center">
  TODO List
</h1>

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org)
- [PostgreSQL](https://www.postgresql.org/download/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [HTTPie](https://httpie.io):

- Criar Tarefa 
```
$ http POST :8080/todos titulo="Todo 1" descricao="Desc Todo 1" vencimento="2025-10-15"

[
  {
    "id": 1,
    "titulo": "Todo 1",
    "descricao": "Desc Todo 1",
    "vencimento": "2025-10-15"
  }
]
```

- Listar Tarefas
```
$ http GET :8080/todos

[
  {
    "id": 1,
    "titulo": "Todo 1",
    "descricao": "Desc Todo 1",
    "vencimento": "2025-10-15"
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/todos/1 titulo="Todo 1 Up" descricao="Desc Todo 1 Up" vencimento="2023-07-15"

[
  {
    "id": 1,
    "titulo": "Todo 1 Up",
    "descricao": "Desc Todo 1 Up",
    "vencimento": "2023-07-15"
  }
]
```

- Remover Tarefa
```
http DELETE :8080/todos/1

[ ]
```