package controller;

import dal.NotaDAO;
import factory.ProfessorFactory;

import java.util.ArrayList;
import model.Nota;

public class NotaController {

    private ArrayList<Nota> notas;
    private NotaDAO notaDAO;

    public NotaController() {
        this.notaDAO = new NotaDAO();
        this.notas = notaDAO.carregar();
    }

    public void cadastrar(Nota nota) throws Exception {
        try {
            notas.add(nota);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void editarNota(int index, String novaDescricao, double novoValor) {
        try {
            Nota nota = notas.get(index);
            nota.setDescricao(novaDescricao);
            nota.setValor(novoValor);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void excluir(int index) {
        try {
            notas.remove(index);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public ArrayList<Nota> listar() {
        return notas;
    }

    private void salvar() {
        notaDAO.salvar(notas);
    }
}
