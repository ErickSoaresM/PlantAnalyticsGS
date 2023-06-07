<h1>🌹Plant Analytics🌹</h1>
A API do aplicativo Plant Analytics, criada com o propósito de permitir que seus usuários enviem fotografias de suas plantas para análise e verificação, oferece a identificação de possíveis doenças e orientações para o tratamento adequado. Vale ressaltar que essa API foi desenvolvida como uma interface REST utilizando a linguagem de programação Java, com a utilização do Spring Framework, que inclui recursos como o Spring Data, Spring Security e Spring HATEOAS.
<h2>Link Vídeo Pitch: https://youtu.be/gJoKOE3Mzqs </h2>
<h2>Link Vídeo ENTERPRISE APPLICATION DEVELOPMENT:</h2>

><h2>Visão geral</h2>
>A API da Plant Analytics serve como a base para um aplicativo móvel que permite aos usuários saberem se suas plantas estão com algum tipo de doença e como trata-la, Ao utilizar essa api os usuarios podem:

>>+ Analise: Envio das fotos das plantas
>>+ Gerenciamento de Usuários: Registrar, fazer login e gerenciar seus perfis, garantindo uma experiência personalizada e segura.
>>+ Autenticação e Segurança: Utilizar autenticação baseada em JWT para aumentar a segurança das contas de usuário.

<h1>🚩Recursos Principais🚩</h1>

><h2>Arquitetura RESTful</h2>
> A API do Plant Analytics foi desenvolvida com base nos princípios da arquitetura Restful, o que permite uma integração eficiente com diversas plataformas, proporcionando um design de API consistente e intuitivo.
><h2>Spring Framework</h2>
> Aproveitando toda a potencialidade do Spring Framework, a API da PlantAnalytics proporciona recursos de injeção de dependência robustos, inversão de controle e programação orientada a aspectos. Essa abordagem promove a criação de um código modular e escalável, o que permite um desenvolvimento ágil e uma manutenção eficiente.
><h2>Spring Data</h2>
> Através da utilização do Spring Data, a API da PlantAnalytics é capaz de se integrar de forma perfeita a diferentes bancos de dados, proporcionando uma persistência e gerenciamento eficazes dos dados. Essa abordagem simplifica a implementação das camadas de acesso aos dados, resultando em melhor desempenho e confiabilidade do sistema como um todo.
><h2>Spring Security</h2>
> A API da Plant Analytics conta com a integração do Spring Security, um framework de segurança altamente confiável e altamente personalizável, com o objetivo de proteger as contas de usuário e os dados sensíveis. A implementação de autenticação baseada em JWT fortalece a segurança, oferecendo aos usuários uma experiência de login perfeita.
><h2>Spring HATEOAS</h2>
> A API da Plant Analytics adota os princípios do Hypermedia as the Engine of Application State (HATEOAS) utilizando o Spring HATEOAS. Essa abordagem enriquece as respostas da API com links de hipermídia, proporcionando aos clientes uma navegação facilitada e a descoberta dos recursos disponíveis na API.

><h2>EndPoints</h2>
+ Usuário
  + [Cadastrar](#cadastrar)
  + [Atualizar Cadastro](#atualizar-cadastro)
  + [Login](#login)
+ Analise
  + [Listar Analise](#listar_analise)
  + [Deletar Analise](#deletar_analise)
  + [Criar Analise](#criar_analise)	 

><h2>Cadastrar</h2>
`post` /api/usuario/cadastrar
><table>
>  <tr>
>    <td>Campo</td>
>    <td>Tipo</td>
>    <td>Obrigatório</td>
>    <td>Descrição</td>
>  </tr>
>  <tr>
>    <td>nome</td>
>    <td>string</td>
>    <td>sim</td>
>    <td>é o nome do usuário, deve respeitar o Regex(^[a-zA-Z]{3,}$)</td>
>  </tr>
>  <tr>
>    <td>email</td>
>    <td>string</td>
>    <td>sim</td>
>    <td>é o email do usuário, deve respeitar o ReGex(^[A-Za-z0-9+_.-]+@(.+)$)</td>
>  </tr>
>  <tr>
>    <td>senha</td>
>    <td>string</td>
>    <td>sim</td>
>    <td>é a senha do usuário, deve ter no mínimo 8 caracteres</td>
>  </tr>
></table>

> Exemplo de request:
```js
{
	"nome": "Erick Soares",
	"email": "ericksoares@gmail.com",
	"senha": "Senha123"
}
```
> Exemplo de response:
```js
{
    "id": 1,
    "nome": "Erick Soares",
    "email": "ericksoares@gmail.com",
    "senha": "$2a$10$GqssjsKV5bTF1h9g0G13X.mEKH5WyKI6JxKNNnI1sdN4pLqA9jjqy",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/usuario/cadastrar"
        },
        "atualizar": {
            "href": "http://localhost:8080/api/usuario/2"
        },
        "logar": {
            "href": "http://localhost:8080/api/usuario/login"
        }
    }
}
```
>Códigos de Resposta
><table>
> <tr>
> <td>Código</td>
>  <td>Descrição</td>
> </tr>
> <tr>
> <td>201</td>
> <td>Usuario cadastrado com sucesso</td>
> </tr>
> <tr>
> <td>400</td>
> <td>Erro na requisição</td>
> </tr>
></table>
>Atualizar cadastro

`PUT` /api/usuario/{id}
>Exemplo de corpo do request
```js
{
	"nome": "Erick Soares",
	"email": "ericksoares@gmail.com",
	"senha": "Senha123"
}
```
>Códigos de resposta
><table>
> <tr>
> <td>Código</td>
>  <td>Descrição</td>
> </tr>
> <tr>
> <td>200</td>
> <td>Usuario atualizado com sucesso</td>
> </tr>
> <tr>
> <td>400</td>
> <td>Erro na requisição</td>
> </tr>
> <tr>
>  <td>404</td>
>  <td>Usuario não encontrado</td>
></table>

>Login

`POST` /api/usuario/login
><table>
>  <tr>
>    <td>Campo</td>
>    <td>Tipo</td>
>    <td>Obrigatório</td>
>    <td>Descrição</td>
>  </tr>
>  <tr>
>    <td>email</td>
>    <td>string</td>
>    <td>sim</td>
>    <td>é o email cadastrado pelo usuário</td>
>  </tr>
>  <tr>
>    <td>senha</td>
>    <td>string</td>
>    <td>sim</td>
>    <td>é a senha cadastrada pelo usuário</td>
>  </tr>
></table>

>Exemplo de request
```js
{
	"email": "usuario@email.com",
	"senha": "senha123"
}
```
>Exemplo de response
><table>
> <tr>
>   <td>Campo</td>
>   <td>Tipo</td>
>   <td>Descrição</td>
> </tr>
> <tr>
>   <td>Token</td>
>   <td>string</td>
>   <td>token do usuario que identifica o usuário no sistema</td>
> </tr>
></table>
```js
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJwZWRyb0BlbWFpbC5jb20uYnIiLCJleHAiOjE2ODQ3ODk5NTcsImlzcyI6IkRyZWFtQ29udHJvbCJ9.dii4kCQsnJEpl4ycu8Z2Mh687_0234MkyNIh_sZPPcQ",
    "type": "JWT",
    "prefix": "Bearer",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/usuario/login"
        },
        "cadastrar": {
            "href": "http://localhost:8080/api/usuario/cadastrar"
        }
    }
}
```
>Códigos de resposta
><table>
> <td>200</td>
> <td>Usuario validado com sucesso</td>
> </tr>
> <tr>
> <td>401</td>
> <td>Usuário ou senha incorretos</td>
> </tr>
></table>

><h2>Análise</h2>
`post`/api/analise
><table>
> <tr>
> <td>Resultado</td>
> <td>Doença</td>
> <td>Data de envio</td>
> <td>Tipo de planta</td>
> </tr>
> <tr>
> <td>Varchar</td>
> <td>Varchar</td>
> <td>Date</td>
> <td>Varchar</td>
> </tr>
></table>

><h2>Diagrama de classes</h2>
![diagrama de classes](https://github.com/ErickSoaresM/PlantAnalyticsGS/assets/101184435/2a108986-ed7d-4f76-92dc-f41b3a235248)
