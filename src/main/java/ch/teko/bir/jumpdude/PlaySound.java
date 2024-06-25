package ch.teko.bir.jumpdude;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound {
    private String jumpSoundPath = "/sprites/pink-man/run.png";

    public void jump() throws LineUnavailableException
    {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(jumpSoundPath);
        AudioInputStream audioStream;
        try {
            audioStream = AudioSystem.getAudioInputStream(inputStream);
            AudioFormat audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
    
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            //audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();
    
            audioClip.close();
            audioStream.close();
            
        } catch (UnsupportedAudioFileException ex) {
        } catch (IOException ex) {
        }
    }
}
