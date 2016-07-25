/******************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, countdown Timer.
 * Date: February 8, 2016
 * Instructor: Paul Hyde Program:
 *******************************************************************************
 * This base class CountdownWorker is provided my instructor. Some codes that is used in method
 * runCountingDown() are taken from chapter 11 of Java Thread Programming. This application is a
 * counting down timer that counts from 10 seconds down to 0, 1 sec at a time.
 * *****************************************************************************
 */
package com.abc.countdown;

public class CountdownWorker {

    private final int totalSeconds;
    private final MinuteSecondDisplay display;
    private volatile boolean keepRunning;
    private volatile String name = "";

    public CountdownWorker(int totalSeconds, MinuteSecondDisplay display) {
        this.totalSeconds = totalSeconds;
        this.display = display;

        // do the self-run pattern to spawn a thread to do the counting down...
        // ...
        Runnable r = new Runnable() {

            @Override
            public void run() {
                runWork();
            }
        };

        Thread counterThread = new Thread(r, "CountdownWorker");
        counterThread.start();
        name = counterThread.getName();
        setName(name);
    }

    private void setName(String newName) {
        this.name = newName;
    }

    // add methods to do the counting down and time correction....
    // call: display.setSeconds(...
    private void runWork() {

        long startTime = System.currentTimeMillis();

        // count down from 10 secs to 0
        for ( int i = 10; i >= 0; i-- ) {
            display.setSeconds(i);
            try {
                Thread.sleep(860);
            } catch ( InterruptedException x ) {
                x.printStackTrace();
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total elapsed time for thread name (" + name +
            ") is " + (endTime - startTime));

    }

}
