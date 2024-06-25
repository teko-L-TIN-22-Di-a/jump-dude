package ch.teko.bir.jumpdude;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class PlaySound {
    private String jumpSoundPath = "/sounds/jump.wav";

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
        catch (Exception e) 
        {

        }
    }
}
