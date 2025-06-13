package factory;

import model.Atividade;

public class AtividadeFactory {
    public static Atividade criar(String matricula, String descricao) {
        return new Atividade(matricula, descricao);
    }
}