package dal;

import java.io.*;
import java.util.ArrayList;
import model.Atividade;
import util.Logger;

public abstract class AtividadeDAO {
    private static final String ARQUIVO = "src/dados/atividades/atividades.dat";

    public static void salvar(ArrayList<Atividade> atividades) {
        try {
            File file = new File(ARQUIVO);
            file.getParentFile().mkdirs(); 
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(atividades);
            }
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar atividades: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static ArrayList<Atividade> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Atividade>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar atividades: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}