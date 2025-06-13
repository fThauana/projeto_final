package factory;

import model.Professor;

public class ProfessorFactory {
    public static Professor criar(String nome, String cpf, String disciplina) {
        return new Professor(nome, cpf, disciplina);
    }
}