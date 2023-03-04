package com.willszabo;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Alarm {
    public static File file;
    public static AudioInputStream audioStream;
    public static Clip clip;

    public Alarm() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    	
    	//File file = new File(".//res//LostAlarm.wav");
    	URL file;
    	file = getClass().getResource("/LostAlarm.wav");
    	
        audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();

    }
}