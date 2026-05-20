# Projeto Backend JAVA Spring Boot - SKILL MAPSTRUCT E DTOs

## Sobre o projeto

Este projeto tem como objetivo implementar a ferramenta MapStruct na aplicação para padronizar e 
otimizar o mapeamento entre entidades e DTOs. Com essa abordagem, buscamos reduzir código repetitivo, 
aumentar a produtividade no desenvolvimento e melhorar a manutenção do sistema. Além disso, o uso do 
MapStruct contribui para maior clareza na camada de serviço, melhor desempenho em tempo de execução 
e menor risco de erros manuais durante as conversões de dados.


## Clonar repositório

```bash
https://github.com/igorprnegrao/projeto-skill-Mapstruct-e-DTO.git
```


# Exemplos de endpoints

## Criar produto

```http
POST /pessoas/cadastro
```


Body:

```json
{
  "nome": "igor",
  "sobrenome": "negrao",
  "email": "igor@email.com",
  "senha": "senhasegura123"
}
```
Response:

```json
{
  "id": "6c2351d1-f56c-48ae-80a4-03d253352b7a"
  "nome": "igor",
  "sobrenome": "negrao",
  "email": "igor@email.com"
}
```

## Fluxo do cadastro

```text
Request
        ↓
Controller
        ↓
DTO
        ↓
Service
        ↓
Mapper
        ↓
Entidade
        ↓
DBA
        ↓
Entidade
        ↓
Mapper
        ↓
DTO
        ↓
Controller
        ↓
Response
```


---

# Autor

## Igor Negrão 

Projeto desenvolvido para fins acadêmicos e prática de desenvolvimento backend com Java, Spring Boot e MapStruct.
