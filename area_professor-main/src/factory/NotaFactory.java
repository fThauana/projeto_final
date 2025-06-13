package factory;

import model.Nota;

public class NotaFactory {
    public static Nota criar(String matricula, String descricao, double valor) {
        return new Nota(matricula, descricao, valor);
    }
}