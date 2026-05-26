package GuiFormulario.Design;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundManager {

    private static Clip clipFundo;

    /**
     * Inicia a reprodução de um ficheiro .wav em loop infinito.
     */
    public static void iniciarMusicaFundo(String caminhoFicheiro) {
        try {
            URL url = SoundManager.class.getResource(caminhoFicheiro);
            if (url == null) {
                System.err.println("Error: Music not found at: " + caminhoFicheiro);
                return;
            }

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
            clipFundo = AudioSystem.getClip();
            clipFundo.open(audioInput);

            // Reduz o volume para não abafar a concentração do utilizador (reduz 15 decibéis)
            FloatControl controloVolume = (FloatControl) clipFundo.getControl(FloatControl.Type.MASTER_GAIN);
            controloVolume.setValue(-15.0f);

            // Inicia em loop contínuo
            clipFundo.loop(Clip.LOOP_CONTINUOUSLY);
            clipFundo.start();

        } catch (Exception e) {
            System.err.println("Error playing audio: " + e.getMessage());
        }
    }

    /**
     * Pára a música de fundo (útil caso queiras adicionar um botão de mute no futuro).
     */
    public static void pararMusica() {
        if (clipFundo != null && clipFundo.isRunning()) {
            clipFundo.stop();
        }
    }
}