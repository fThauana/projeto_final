package model;

public class Falta extends RegistroAcademico {
    public Falta(String alunoMatricula, String descricao) {
        super(alunoMatricula, descricao);
    }

    @Override
    public String exibir() {
        return "Falta - " + alunoMatricula + ": " + descricao;
    }
}