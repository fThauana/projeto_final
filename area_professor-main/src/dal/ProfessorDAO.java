package dal;

import java.io.*;
import java.util.ArrayList;
import model.Professor;
import util.Logger;

public class ProfessorDAO {
    private final String ARQUIVO = "src/dados/professores/professores.dat";

    public void salvar(ArrayList<Professor> professores) {
        try {
            File file = new File(ARQUIVO);
            file.getParentFile().mkdirs(); 
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(professores);
            }
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar professores: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Professor> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Professor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar professores: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}