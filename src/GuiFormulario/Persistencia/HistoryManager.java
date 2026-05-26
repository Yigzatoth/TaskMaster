package GuiFormulario.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import GuiFormulario.Modelos.FichaDados;

public class HistoryManager {
    
    private static final String FOLDER_NAME = "SaveData";

    /**
     * Varre a pasta SaveData e carrega todas as fichas .ser para uma lista em memória.
     */
    public static List<FichaDados> carregarTodasAsFichas() {
        List<FichaDados> lista = new ArrayList<>();
        File pasta = new File(FOLDER_NAME);
        
        if (!pasta.exists() || !pasta.isDirectory()) return lista;

        File[] ficheiros = pasta.listFiles();
        if (ficheiros == null) return lista;

        for (File f : ficheiros) {
            if (f.isFile() && f.getName().endsWith(".ser")) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                    FichaDados dados = (FichaDados) ois.readObject();
                    lista.add(dados);
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error reading file in history: " + f.getName());
                }
            }
        }
        return lista;
    }
}