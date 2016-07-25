/******************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, countdown Timer.
 * Date: February 8, 2016
 * Instructor: Paul Hyde Program:
 *******************************************************************************
 * This base class MinuteSecondDisplay is provided by my instructor.

 * This class works with a CountdownWorker class to facilitate the functionality
 *  of a counting down timer that counts from 10 seconds down to 0, 1 sec at a time.
 * *****************************************************************************
 */
package com.abc.countdown;

import java.awt.*;
import java.text.*;

import javax.swing.*;

public class MinuteSecondDisplay extends JPanel {
    private static final Font TIME_FONT = new Font("Monospaced", Font.BOLD, 24);
    private static final NumberFormat FORMATTER;

    static {
        NumberFormat f = NumberFormat.getInstance();
        f.setMaximumFractionDigits(0);
        f.setMaximumIntegerDigits(2);
        f.setMinimumIntegerDigits(2);
        FORMATTER = f;
    }

    private volatile int seconds;
    private boolean delayOn;
    private Runnable updateTask;
    private JLabel timeL;

    public MinuteSecondDisplay() {
        seconds = 0;
        delayOn = true;

        updateTask = new Runnable() {
            @Override
            public void run() {
                updateTimeLabel();
            }
        };

        timeL = new JLabel("00:00", JLabel.CENTER);
        timeL.setFont(TIME_FONT);
        timeL.setForeground(Color.BLACK);
        updateTimeLabel();

        setLayout(new GridLayout());
        setBorder(BorderFactory.createEtchedBorder());
        add(timeL);
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
        SwingUtilities.invokeLater(updateTask);

        if ( delayOn && (seconds > 0) ) {
            // exaggerates time to run this method
            takeRandomMiniNap();
        }
    }

    private void takeRandomMiniNap() {
        try {
            // sleep for 0 to 99 ms
            long napTime = (long) (Math.random() * 100.0);
            Thread.sleep(napTime);
        } catch ( InterruptedException x ) {
            Thread.currentThread().interrupt(); // reassert intr
            return;
        }
    }

    private void updateTimeLabel() {
        int totalSec = seconds; // capture current value snapshot
        int sec = totalSec % 60;
        int min = (totalSec / 60) % 60;
        timeL.setText(FORMATTER.format(min) + ":" + FORMATTER.format(sec));
    }
}
