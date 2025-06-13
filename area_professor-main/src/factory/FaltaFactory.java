package factory;

import model.Falta;

public class FaltaFactory {
    public static Falta criar(String matricula, String descricao) {
        return new Falta(matricula, descricao);
    }
}