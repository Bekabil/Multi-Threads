/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, prime numbers generator.
 * Date: February 15, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class PrimePrinter is written and provided by my instructor.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * *************************************************************************************
 */
package com.abc.prime;

import com.abc.prime.LongFifo.RemoveResult;

public class PrimePrinter {
    private final LongFifo inputFifo;

    public PrimePrinter(LongFifo inputFifo) {
        this.inputFifo = inputFifo;

        new Thread(new Runnable() {
            @Override
            public void run() {
                runWork();
            }
        }, "PrimePrinter").start();
    }

    private void runWork() {
        // take a prime off the "known to be prime" FIFO and print it out...
        // ... if there aren't any, sleep a bit, then try again....
        try {
            int maxCountPerLine = 10;
            int currCount = 0;
            while ( true ) {
                RemoveResult rr = null;
                while ( !(rr = inputFifo.remove()).isValid() ) {
                    Thread.sleep(500);
                }

                System.out.printf("%7d  ", rr.getValue());
                currCount++;
                if (currCount == maxCountPerLine) {
                    System.out.println();
                    currCount = 0;
                }
            }
        } catch ( InterruptedException x ) {
            // ignore and let the thread die
        }

    }
}
