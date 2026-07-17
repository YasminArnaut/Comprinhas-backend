# Cadastro do Comprinhas 🫧

## Descrição 🧾

Esta funcionalidade permite o cadastro de novas compras na aplicação, possibilitando o acompanhamento e gerenciamento das aquisições realizadas pelos usuários.

A implementação segue a arquitetura da aplicação, utilizando as camadas de **Controller**, **Service** e **Repository** para garantir a separação de responsabilidades e a manutenção das regras de negócio.

## Fluxo de Funcionamento 💡

1. O cliente envia uma requisição para cadastro de uma nova compra.
2. A camada **Controller** recebe a requisição e valida os dados de entrada.
3. A camada **Service** aplica as regras de negócio da funcionalidade.
4. A camada **Repository** realiza a persistência dos dados no banco de dados.
5. A compra é armazenada com o status padrão **"comprado"**.

## Campos Obrigatórios 📌

Para que o cadastro seja realizado com sucesso, os seguintes campos devem ser informados:

| Campo                    | Descrição                            |
| ------------------------ | ------------------------------------ |
| Nome da compra           | Nome ou identificação da compra      |
| Descrição                | Descrição detalhada da compra        |
| Valor                    | Valor monetário da compra            |
| Data do pedido           | Data em que a compra foi realizada   |
| Loja da compra           | Nome da loja ou estabelecimento      |
| Data prevista de entrega | Data estimada para entrega do pedido |

## Regras de Negócio 📝

* Todos os campos obrigatórios devem ser preenchidos e validados.
* O cadastro somente será concluído caso todas as validações sejam atendidas.
* O status da compra será definido automaticamente como **"comprado"** no momento da criação.
* A compra deverá ser persistida com sucesso no banco de dados.

## Exemplo de Payload 📎

```json
{
        "id": 51,
        "nomeProduto": "maquiagem",
        "descricao": "Base liquida",
        "valor": 20.01,
        "dataCompra": "2026-01-21",
        "nomeLoja": "magalu",
        "dataEntrega": "2026-01-23",
        "status": "Comprado"
}
```

## Resultado Esperado ✨🔋

Após o cadastro bem-sucedido:

* A compra será salva no banco de dados.
* O status será atribuído automaticamente como `"comprado"`.
* A aplicação retornará uma confirmação de criação da compra.
