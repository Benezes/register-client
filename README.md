# Client Register API
## Api que registra clientes.

## Stack

- Java 11
- Maven
- Spring Boot (v2.4.4)
- H2
- Model Mapper (v2.4.2)

## Paths - Client

| Função | Caminho |
| ------ | ------ |
| GET | /clients/ |
| GET | /clients/id |
| POST | /clients/ |
| PUT | /clients/id |
| DELETE | /clients/id |

## Collection Postman
> https://www.getpostman.com/collections/8a0b443c0f4a940b8e07

### Buscando um cliente
GET /clients/1

### Buscando um cliente por id
GET /clients/1


### Inserção de novo cliente
POST /clients
```
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

### Atualização de cliente
PUT /clients/1
```
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

### Deleção de cliente
DELETE /clients/1
