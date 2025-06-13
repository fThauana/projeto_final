package model;

public class Atividade extends RegistroAcademico {
    public Atividade(String alunoMatricula, String descricao) {
        super(alunoMatricula, descricao);
    }

    @Override
    public String exibir() {
        return "Atividade - " + alunoMatricula + ": " + descricao;
    }
}