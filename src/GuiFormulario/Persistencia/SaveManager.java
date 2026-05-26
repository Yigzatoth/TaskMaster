package GuiFormulario.Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import GuiFormulario.Modelos.FichaDados;

public class SaveManager {
    private static final String FOLDER_NAME = "SaveData";

    /**
     * Grava ou substitui um objeto FichaDados no disco.
     */
    public static boolean gravarDados(FichaDados dados, int serial) {
        try {
            File pasta = new File(FOLDER_NAME);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            // PRIORIDADE 2: Se já existir um ficheiro físico para este serial (modo modificar), mantém o
            // ficheiro antigo
            File ficheiro = encontrarFicheiroPorSerial(serial);

            // PRIORIDADE 2: Se não encontrou, cria um nome novo com a data atual (modo nova entrada)
            if (ficheiro == null) {
                String nomeFicheiro = "form_"
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                        + String.format("_%04d.ser", serial);
                ficheiro = new File(pasta, nomeFicheiro);
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro))) {
                oos.writeObject(dados);
            }

            SerialManager.atualizarContador(serial);
            return true;

        } catch (IOException e) {
            System.err.println("Error saving object: " + e.getMessage());
            return false;
        }
    }

    /**
     * PRIORIADE 1: Procura e carrega uma FichaDados do disco baseando-se apenas no
     * ID (Número de Série).
     */
    public static FichaDados carregarDados(int serial) {
        File ficheiro = encontrarFicheiroPorSerial(serial);
        if (ficheiro == null || !ficheiro.exists()) {
            return null; // Retorna nulo se o número de série não existir no disco
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro))) {
            return (FichaDados) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading object: " + e.getMessage());
            return null;
        }
    }

    /**
     * PRIORIDADE 3: Remove fisicamente o ficheiro correspondente ao número de série
     * do disco.
     */
    public static boolean apagarDados(int serial) {
        File ficheiro = encontrarFicheiroPorSerial(serial);
        if (ficheiro != null && ficheiro.exists()) {
            return ficheiro.delete();
        }
        return false;
    }

    /**
     * Método auxiliar privado para varrer a pasta e encontrar o ficheiro correto
     * pelo sufixo do ID.
     */
    private static File encontrarFicheiroPorSerial(int serial) {
        File pasta = new File(FOLDER_NAME);
        if (!pasta.exists() || !pasta.isDirectory()) {
            return null;
        }

        File[] ficheiros = pasta.listFiles();
        if (ficheiros == null)
            return null;

        String sufixoProcurado = String.format("_%04d.ser", serial);

        for (File f : ficheiros) {
            if (f.isFile() && f.getName().endsWith(sufixoProcurado)) {
                return f;
            }
        }
        return null;
    }
}