### Encerrar uma TeleChamada

Encerrar uma TeleChamada de acordo com o ID informado

- **Método:** `UPDATE`
- **Ponto de acesso:** `api/v1/telecall`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8095/api/v1/telecall/96b12c9e-3e02-49fa-80fa-29397d05e490' \
--header 'Content-Type: application/json' \
--data '{}'
```
    PUT  api/v1/telecall/{Id}

[< Voltar para o índice](../README.md)