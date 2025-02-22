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
curl --location --request POST 'http://localhost:8095/api/v1/telecall'
```
    POST  api/v1/telecall

#### Exemplo de resposta de sucesso

```json
{
  "uuid": "96b12c9e-3e02-49fa-80fa-29397d05e490",
  "initialDateTime": null,
  "finalDateTime": null
}
```

[< Voltar para o índice](../README.md)
