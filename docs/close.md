### Encerrar uma TeleChamada

Encerrar uma TeleChamada de acordo com o ID informado

- **Método:** `UPDATE`
- **Ponto de acesso:** `api/v1/telecall`
- **Código HTTP:** `200 OK`

#### Parâmetro

```shell
curl --location --request PUT 'http://localhost:8095/api/v1/telecall/f256ad56-7a1f-4c9b-84cf-fffe38f36ef6' \
--header 'Content-Type: application/json' \
--data '{}'
```
    PUT  api/v1/telecall/{Id}

[< Voltar para o índice](../README.md)