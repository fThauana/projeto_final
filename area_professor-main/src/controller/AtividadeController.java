package controller;

import dal.AtividadeDAO;
import java.util.ArrayList;
import model.Aluno;
import model.Atividade;

public class AtividadeController {

    private ArrayList<Atividade> atividades;

    public AtividadeController() {
        this.atividades = AtividadeDAO.carregar();
    }

    public void cadastrar(Atividade atividade) {
        try {
            atividades.add(atividade);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void editar(int index, String novaDescricao) {
        try {
            atividades.get(index).setDescricao(novaDescricao);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void excluir(int index) {
        try {
            atividades.remove(index);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void lancarParaTurma(Aluno[] alunos, String descricao) {
        try {
            for (Aluno a : alunos) {
                atividades.add(new Atividade(a.getMatricula(), descricao));
            }
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public ArrayList<Atividade> listar() {
        return atividades;
    }

    private void salvar() {
        AtividadeDAO.salvar(atividades);
    }
}
