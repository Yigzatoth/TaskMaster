package GuiFormulario.Persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SerialManager {
    private static final String CONTROL_FILE = "SaveData/contador.txt";

    /**
     * Lê o último número de série gravado. Se não existir, começa no 1.
     */
    public static synchronized int obterProximoSerial() {
        int serial = 1;
        File ficheiro = new File(CONTROL_FILE);

        // Se o ficheiro já existir, lê o número que está lá dentro
        if (ficheiro.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ficheiro))) {
                String linha = reader.readLine();
                if (linha != null) {
                    serial = Integer.parseInt(linha.trim());
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error reading counter, using default value 1: " + e.getMessage());
            }
        }
        return serial;
    }

    /**
     * Atualiza o ficheiro de controlo com o próximo número disponível.
     */
    public static synchronized void atualizarContador(int atual) {
        File ficheiro = new File(CONTROL_FILE);
        // Garante que a pasta SaveData existe antes de gravar o txt de controlo
        File pasta = ficheiro.getParentFile();
        if (pasta != null && !pasta.exists()) {
            pasta.mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(ficheiro))) {
            writer.print(atual + 1); // Guarda o número seguinte para a próxima ficha
        } catch (IOException e) {
            System.err.println("Error updating counter file: " + e.getMessage());
        }
    }
}