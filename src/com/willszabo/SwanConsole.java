package com.willszabo;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class SwanConsole {
    static final int MILLISECONDS = 1;
    static final int SECONDS = 1000 * MILLISECONDS;
    static final int MINUTES =  60 * SECONDS;

    public static Boolean checkTheNumbers(String userInput) {

        final String THE_NUMBERS = "4 8 15 16 23 42";

        if(userInput.equals(THE_NUMBERS)) {
            System.out.println("Here is your userInput value -> " + userInput);
            System.out.println("YOU DON'T DIE FOR 108 MINUTES");
            Alarm.clip.stop();
            GUI.userText.setText("");
            
            //Instantiate and declare my two timers. One will count down from 108 minutes, the other will countdown from 4 minutes.
            Timer oneOEightTimer = new Timer();
            Timer fourMinuteTimer = new Timer();

            // Create TimerTask alarmStart that plays LostAlarm when called.
            TimerTask alarmStart = new TimerTask() {
                @Override
                public void run() {
                    try {
                        Alarm alarm = new Alarm();
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
            TimerTask fourMinuteWarning = new TimerTask() {
                @Override
                public void run() {
                    fourMinuteTimer.schedule(alarmStart, 0);
                };
            };


            //Schedule the Timer Task to be triggered when the oneOEight Timer hits 0, the four minute alarm, and specify the delay before triggered.
            oneOEightTimer.schedule(fourMinuteWarning, 104 * MINUTES);


            return true;
        } else {
            System.out.println("here is your userInput value -> " + userInput);
            System.out.println("SEE YOU IN ANOTHER LIFE BROTHER");
            return false;
        }
    }
}
