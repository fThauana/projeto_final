# Sistema de Gerenciamento Escolar (Console em Java)

Este projeto é um Sistema de Gerenciamento Escolar desenvolvido em Java, utilizando arquitetura MVC, princípios de Orientação a Objetos e interação via console.  
O sistema permite o gerenciamento de Professores, Faltas, Notas e Atividades.

## Funcionalidades

### Professores
- Cadastrar professor
- Listar professores
- Editar professor
- Excluir professor

### Faltas
- Registrar falta
- Listar faltas
- Editar falta
- Excluir falta

### Notas
- Registrar nota
- Listar notas
- Editar nota
- Excluir nota

### Atividades
- Cadastrar atividade
- Listar atividades
- Editar atividade
- Excluir atividade
- Lançar atividade para toda a turma

---

## Tecnologias Utilizadas
- Java SE
- Programação Orientada a Objetos
- Coleções (List, Map, ArrayList, HashMap)
- Java Time (LocalDate, ChronoUnit)
- Arquitetura MVC

---

## Estrutura Geral do Projeto 

  ```
    src/
├── controller/
│    ├── AtividadeController.java
│    ├── FaltaController.java
│    ├── NotaController.java
│    └── ProfessorController.java
|
├── dal/
│    ├── AtividadeDAO.java
│    ├── FaltaDAO.java
│    ├── NotaDAO.java
│    ├── ProfessorDAO.java
|
├── factory/
│    ├── AtividadeFactory.java
│    ├── FaltaFactory.java
│    ├── NotaFactory.java
│    ├── ProfessorFactory.java
|
├── model/
│    ├── AtividadeFactory.java
│    ├── FaltaFactory.java
│    ├── NotaFactory.java
│    ├── ProfessorFactory.java
|
├── util/
│    ├── Logger.java
│    ├── PreCarga.java
│
├── view/
│    ├── MenuView.java
│
└── App.java 

  ```

---

## Como Executar

Pré-requisitos
- Java 8+
- Qualquer IDE (IntelliJ, Eclipse, NetBeans) ou terminal.

Execução via terminal
  ```
  javac Main.java
  java Main
  ```

---

## Demonstração do Menu Principal
  ```
  --- MENU PRINCIPAL ---
  1. Professores
  2. Faltas
  3. Notas
  4. Atividades
  0. Sair
  ```
Cada módulo possui seu próprio CRUD totalmente funcional.

---

## Aprendizados e Práticas Envolvidas
✔ Uso completo dos pilares da Orientação a Objetos

✔ Estruturação em MVC

✔ Criação e uso de Factories

✔ Listas e manipulação dinâmica de dados

✔ Tratamento de exceções

✔ Sistema navegável via console

---

## Licença

Projeto desenvolvido apenas para fins acadêmicos, não destinado a uso comercial.
