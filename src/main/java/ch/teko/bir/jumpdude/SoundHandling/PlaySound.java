package ch.teko.bir.jumpdude.SoundHandling;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySound {
    private final String jumpSoundPath = "/sounds/jump.wav";

    public void jump()
    {
        try 
        {
            var audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(jumpSoundPath));
            var fileFormat = audioInputStream.getFormat();
            var dataLineInfo = new DataLine.Info(Clip.class, fileFormat);
            var soundClip = (Clip) AudioSystem.getLine(dataLineInfo);
            soundClip.open(audioInputStream);
            soundClip.start();
        } 
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) 
        {

        }
    }
}
