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

![Texto alternativo da imagem](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgHome.png)

* Tela que exibe a lista de Especialidades cadastrada
  ![Tela Especialistas](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgEspec.png)

* Tela que exibe a lista de medicos cadastrados
![Tela que exibe a lista de medicos cadastrados no sistema](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgMedicos.png)

* Tela que exibe uma lista dos pocientes cadastrados na clínica com quem eles têm ou terao consulta
![Pacientes cadastrados na clínica](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgPacientes.png)

* Uma lista das consultas agendadas e as suas datas e horarios e outros dados
![Lista de consultas agendadas na clínica](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgPacientes.png)

* Menu com opções de serviços do sistema como cadastros
![Lista de opções suspensa no menu](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgOpcoesCadastro.png)

* Exemplo de Tela de Cadastro
![Tela de cadastro](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgTelaCadastro.png)

* O sistema também possibilita a edição de consultas ou cancelamentos
![Edicao de consulta](https://github.com/wemersonnino/sistema-de-gestao-de-consultas-medicas/blob/main/src/main/resources/static/images/imgEditPaciente.png)


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
Feito com muito ☕️ ❤️ e bastante empolgação por Wemerson Nino