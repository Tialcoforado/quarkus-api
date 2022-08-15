# bb-Quarkus-dev


O bb-Quarkus-dev é um microsserviço que visa prover uma aplicação de teste que experiementa com o framework quarkus

O projeto explora conceitos de rest e de banco de dados.
Existem duas entidades, Cliente e Categoria. Esses possuem seus respectivos Models, Repositorys, Services e Resources(rest)

É possível manipular as entidades em banco de dados carregado localmente via métodos Http GET, POST, PUT, E DELETE. 
Quando o projeto é carregado existem duas categorias pré-carregadas em banco para a entidade Categoria, programador e comerciante


Este projeto é codificado em Java e utiliza o framework [Quarkus](<https://quarkus.io/>).


Para rodar o projeto, execute os comandos dentro do diretorio criado para o projeto.

Execute o comando abaixo: 

```bash 
mvn install quarkus:dev             
```

Nota: você deve ter o maven instalado na sua máquina e o arquivo settings.xml devidamente configurado na pasta .m2 (ela fica no home da sua máquina). Você deve pegar o settings pelo site do atf (atf.intranet.bb.com.br) pela opção bb-mavem-repo. Sete a sua senha do sisbb antes de gerar o arquivo para que ele contenha o hash dela. 

O seu projeto será executado com hot deploy. Com esta opção, caso você faça alguma alteração no seu código, ela já será refletida no projeto em execução, não sendo necessário derrubar o projeto e subi-lo novamente. 

Acesse o endpoint **hello world** no caminho: http://localhost:8080/v1/hello



A fim de expor as váriaveis de ambiente, versão da aplicação e outras informações deste projeto, foi configurado o seguinte endpoint: <http://localhost:8080/info>

Para acessar a documentação da API no Swagger UI, acesse o endpoint: <http://localhost:8080/api-specs/ui/>





Neste projeto foram incluídos exemplos de testes unitários implementados utilizando o QuarkusTest.

Para editar os testes unitários, edite as classes do diretório: **/src/test/**.

Para executar os testes unitários, execute o comando:

``` bash
mvn test
```

Ao executar o script run.sh ou o run_hot_deploy.sh, os testes também são executados e você pode conferir os resultados destes no console. 