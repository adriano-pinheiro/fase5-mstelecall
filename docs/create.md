### Criar uma nova TeleChamada

Endpoint para criação de uma nova TeleChamada.

- **Método:** `POST`
- **Ponto de acesso:** `api/v1/telecall`
- **Código HTTP:** `201 CREATED`

#### Parâmetro
| **Campo**      | **Tipo**          | **Descrição**                              | **Requerido** | **Enum** |
|----------------|-------------------|--------------------------------------------|---------------|----------|
| id             | UUID              | Identificador único da TeleChamada         | Não           |          |
| initialDateTime| LocalDateTime     | Data e hora de início da TeleChamada       | Não           |          |
| finalDateTime  | LocalDateTime     | Data e hora de término da TeleChamada      | Não           |          |



```shell
curl --location 'http://localhost:8095/api/v1/telecall' \
--header 'Content-Type: application/json' \
--data '{}'
```
    POST  api/v1/telecall

#### Exemplo de resposta de sucesso

```json
{
  "uuid": "e38566c3-acb9-44ca-bb93-fd1f844e5471",
  "initialDateTime": null,
  "finalDateTime": null
}
```

[< Voltar para o índice](../README.md)
