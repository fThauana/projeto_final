package model;

import java.io.Serializable;

public abstract class RegistroAcademico implements Serializable {
    protected String alunoMatricula;
    protected String descricao;

    public RegistroAcademico(String alunoMatricula, String descricao) {
        this.alunoMatricula = alunoMatricula;
        this.descricao = descricao;
    }

    public String getAlunoMatricula() { return alunoMatricula; }
    public void setAlunoMatricula(String alunoMatricula) { this.alunoMatricula = alunoMatricula; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public abstract String exibir();
}