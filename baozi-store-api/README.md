# Baozi Store API REST
Projeto didático em Java 17 + Spring Boot + Spring Data JPA + H2 em memória.

## Executar
Instale JDK 17 e Maven. Na pasta do projeto, execute `mvn spring-boot:run`.
API: `http://localhost:8080/api`

## Endpoints
Para `clientes`, `produtos` e `pedidos`: POST `/api/{recurso}`, GET `/api/{recurso}`, GET `/api/{recurso}/{id}`, DELETE `/api/{recurso}/{id}`.

## JSON de exemplo
Cliente: `{"nome":"PedroLeandroSilva5186859","clienteDesde":"2026-10-12"}`
Produto: `{"nome":"Baozi tradicional","preco":8.50,"estoque":true}`
Pedido: `{"clienteId":1,"produtoId":1,"quantidade":3}`

O banco H2 é em memória e reinicia os dados quando a aplicação é encerrada.
