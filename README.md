# Sistema de Gestão de Consultas Médicas 🏥

#Descrição:

👨‍⚕️ Este projeto é um sistema de gestão de consultas médicas que permite cadastrar médicos,
pacientes, especialidades médicas e consultas.

### O sistema foi desenvolvido usando Spring Boot, Maven e Java, e está separado em camadas:

* **Camada de apresentação:** Responsável pela interação com o usuário.
* **Camada de negócios:** Responsável pela lógica do negócio.
* **Camada de dados:** Responsável pelo acesso aos dados.

> O sistema realiza operações CRUD (Create, Read, Update, Delete) nas entidades:
> * **Médico:** Responsável por realizar consultas médicas.
> * **Paciente:** Responsável por agendar consultas médicas.
> * **Especialidade Médica:** Responsável por classificar as consultas médicas.
> * **Consulta:** Representa uma consulta médica.

#### As relações entre as entidades são as seguintes:

* **Médico:** Um médico pode realizar várias consultas.
* **Paciente:** Um paciente pode agendar várias consultas.
* **Consulta:** Uma consulta é realizada por um médico e agendada por um paciente.

## Tecnologias utilizadas:

* **Spring Boot** 🚀
* **Maven** 🏗️
* **Java** ☕️
* **JPA** 💾
* **Hibernate** 🧙‍♂️
* **H2** 💧

## Demonstração:

[Link para a demonstração do sistema]

## Como rodar o projeto:

```agsl
git clone https://github.com/[seu-usuário]/sistema-de-gestao-de-consultas-medicas.git
cd sistema-de-gestao-de-consultas-medicas
mvn clean install
mvn spring-boot:run
```
Depois acesse o endereço para visualizar a aplicação no navegador:
[localhost:8080](http://localhost:8080/)

## Contribuição:

Sinta-se à vontade para contribuir com este projeto!

## Licença:

Este projeto está licenciado sob a licença MIT.

-------------------------------------------------------------
Feito com muito ☕️ e ❤️ por Wemerson Nino