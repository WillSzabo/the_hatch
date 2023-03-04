package com.willszabo;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class DHARMA_Initiative {
	
    static final int MILLISECONDS = 1;
    static final int SECONDS = 1000 * MILLISECONDS;
    static final int MINUTES =  60 * SECONDS;
    static TimerTask fourMinuteWarning;
    static Timer oneSecondTimer;
    static Alarm alarm;

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        // Instantiate and declare main graphical user interface
		GUI mainGUI = new GUI();


        //Instantiate and declare two timers. One will count down from 108 minutes, the other will countdown from 4 minutes.
        oneSecondTimer = new Timer();
        Timer fourMinuteTimer = new Timer();

        // Create TimerTask alarmStart that plays LostAlarm when called.
        TimerTask alarmStart = new TimerTask() {
            @Override
            public void run() {
                try {
                    alarm = new Alarm();
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        //Create TimerTask fourMinuteWarning
        fourMinuteWarning = new TimerTask() {
            @Override
            public void run() {
                fourMinuteTimer.schedule(alarmStart, 0);
            };
        };


        //Schedule the Timer Task to be triggered when the oneOEight Timer hits 0, and specify the delay before triggered.
        oneSecondTimer.schedule(fourMinuteWarning, 2 * SECONDS);

    }
}