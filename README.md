# Cinelist
Este é um sistema simples de gestão de filmes desenvolvido em Node.js com o uso do framework Express e o ORM TypeORM. Ele fornece endpoints para criar, listar, atualizar e excluir filmes.

## Configuração do Projeto
1. Clonar o repositório

```bash
$ git clone https://github.com/wladsonramos/backend-cinelist.git
```

2. Instalar dependências: Navegue até o diretório do projeto e execute

```bash
$ npm install
```

## Configuração do Banco de Dados
O projeto utiliza o banco de dados PostgreSQL. Certifique-se de ter um servidor PostgreSQL em execução e configure as credenciais no arquivo data-source.ts.

Exemplo de data-source.ts:

```markdown
export const AppDataSource = new DataSource({
    type: "postgres",
    host: "localhost",
    port: 5432,
    username: "test",
    password: "test",
    database: "test",
    synchronize: true,
    logging: true,
    entities: [],
    subscribers: [],
    migrations: [],
})
```

## Executando o Servidor
Para iniciar o servidor, execute:

```bash
$ npm run dev
```

O servidor estará em execução em http://localhost:3000.

# Endpoints

## Criar Filme

- URL: /films
- Método: POST
- Corpo da Requisição:

```json
{
    "title": "Nome do Filme",
    "description": "Descrição do Filme",
    "watched_at": "Data em formato ISO (opcional)"
}
```

- Resposta de Sucesso:
  - Código: 201 Created
  - Conteúdo: Objeto do Filme criado
 
## Listar Filmes

- URL: /films
- Método: GET
- Resposta de Sucesso:
  - Código: 200 OK
  - Conteúdo: Array de Objetos de Filmes

## Atualizar Filme
- URL: /films/:id
- Método: PUT
- Parâmetros de Rota: id (ID do Filme)
- Corpo da Requisição (Opcional):

```json
{
    "title": "Novo Nome do Filme",
    "description": "Nova Descrição do Filme",
    "watched_at": "Nova Data em formato ISO"
}
```

- Resposta de Sucesso:
  - Código: 200 OK
  - Conteúdo: Objeto do Filme atualizado
 
## Excluir Filme

- URL: /films/:id
- Método: DELETE
- Parâmetros de Rota: id (ID do Filme)
- Resposta de Sucesso:
  - Código: 204 No Content
 
## Contribuição
Sinta-se à vontade para contribuir com melhorias ou correções de bugs. Basta abrir uma issue ou enviar um pull request.
