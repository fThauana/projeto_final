package controller;

import dal.FaltaDAO;
import java.util.ArrayList;
import model.Falta;

public class FaltaController {

    private ArrayList<Falta> faltas;
    private FaltaDAO faltaDAO;

    public FaltaController() {
        this.faltaDAO = new FaltaDAO();
        this.faltas = faltaDAO.carregar();
    }

    public void cadastrar(Falta falta) {
        try {
            faltas.add(falta);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void editar(int index, String novaDescricao) {
        try {
            faltas.get(index).setDescricao(novaDescricao);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public void excluir(int index) {
        try {
            faltas.remove(index);
            salvar();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao executar operação: " + e.getMessage());
        }
    }

    public ArrayList<Falta> listar() {
        return faltas;
    }

    private void salvar() {
        faltaDAO.salvar(faltas);
    }
}
