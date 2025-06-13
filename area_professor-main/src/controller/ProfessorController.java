package controller;

import dal.ProfessorDAO;
import factory.ProfessorFactory;
import java.util.ArrayList;
import model.Professor;

public class ProfessorController {

    private ArrayList<Professor> professores;
    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO();
        this.professores = professorDAO.carregar();
    }

    public void cadastrar(String nome, String cpf, String disciplina) {
        try {

            professores.add(ProfessorFactory.criar(nome, cpf, disciplina));
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public ArrayList<Professor> listar() {
        return professores;
    }

    public void editar(int index, String nome, String cpf, String disciplina) {
        try {

            Professor p = professores.get(index);
            p.setNome(nome);
            p.setCpf(cpf);
            p.setDisciplina(disciplina);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void excluir(int index) {
        try {

            professores.remove(index);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    private void salvar() {
        professorDAO.salvar(professores);
    }
}
