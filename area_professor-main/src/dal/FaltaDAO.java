package dal;

import java.io.*;
import java.util.ArrayList;
import model.Falta;
import util.Logger;

public class FaltaDAO {
    private final String ARQUIVO = "src/dados/faltas/faltas.dat";

    public void salvar(ArrayList<Falta> faltas) {
        try {
            File file = new File(ARQUIVO);
            file.getParentFile().mkdirs(); 
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(faltas);
            }
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar faltas: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Falta> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Falta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar faltas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}