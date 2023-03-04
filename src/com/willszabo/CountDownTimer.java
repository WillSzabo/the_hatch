package com.willszabo;

import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimer {
	
    //declare timer t
    Timer timer;
    final int MILLISECONDS = 1000;
    final int SECONDS = 60;
    String myString;

    //Constructor
    public CountDownTimer(int minutes, String cdMessage) {
        timer = new Timer();
        //schedule the timer
        timer.schedule(new rt(), minutes * SECONDS * MILLISECONDS);
        myString = cdMessage;
    }


    //subclass that extends TimerTask
    class rt extends TimerTask {

        //task to perform on executing the program
        public void run() {
            System.out.println(myString);
            timer.cancel(); //stop the thread of timer
        }
        
    }

}