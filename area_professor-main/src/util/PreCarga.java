package util;

import controller.AtividadeController;
import controller.FaltaController;
import controller.NotaController;
import controller.ProfessorController;
import factory.AtividadeFactory;
import factory.FaltaFactory;
import factory.NotaFactory;
import model.Aluno;

public class PreCarga {

    private static final Aluno[] ALUNOS_EXEMPLO = {
        new Aluno("Ana", "A001"),
        new Aluno("Bruno", "A002"),
        new Aluno("Carla", "A003")
    };

    public static void initializeData(
            ProfessorController professorController,
            FaltaController faltaController,
            NotaController notaController,
            AtividadeController atividadeController) {

        if (professorController.listar().isEmpty()) {
            professorController.cadastrar("João Silva", "111.222.333-44", "Matemática");
            professorController.cadastrar("Maria Santos", "555.666.777-88", "Português");
            professorController.cadastrar("Pedro Costa", "999.888.777-66", "Física");
            Logger.registrar("Pré-carga de professores realizada.");
        }

        if (faltaController.listar().isEmpty()) {
            faltaController.cadastrar(FaltaFactory.criar("A001", "Atestado médico"));
            faltaController.cadastrar(FaltaFactory.criar("A002", "Viagem familiar"));
            faltaController.cadastrar(FaltaFactory.criar("A003", "Compromisso pessoal"));
            Logger.registrar("Pré-carga de faltas realizada.");
        }

        if (notaController.listar().isEmpty()) {
            notaController.cadastrar(NotaFactory.criar("A001", "Prova 1", 8.5));
            notaController.cadastrar(NotaFactory.criar("A002", "Trabalho em Grupo", 7.0));
            notaController.cadastrar(NotaFactory.criar("A003", "Participação", 9.0));
            Logger.registrar("Pré-carga de notas realizada.");
        }

        if (atividadeController.listar().isEmpty()) {
            atividadeController.cadastrar(AtividadeFactory.criar("A001", "Trabalho de Biologia - Cap. 1"));
            atividadeController.cadastrar(AtividadeFactory.criar("A002", "Redação sobre o Meio Ambiente"));
            atividadeController.cadastrar(AtividadeFactory.criar("A003", "Pesquisa de História - Era Vargas"));
            
            atividadeController.lancarParaTurma(ALUNOS_EXEMPLO, "Exercício de Revisão");
            Logger.registrar("Pré-carga de atividades realizada.");
        }
    }
}