/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, prime numbers generator.
 * Date: February 15, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class CandidateGenerator is written and provided by my instructor.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * *************************************************************************************
 */
package com.abc.prime;

public class CandidateGenerator {
    private final LongFifo outputFifo;

    public CandidateGenerator(LongFifo outputFifo) {
        this.outputFifo = outputFifo;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                runWork();
            }
        };

        Thread t = new Thread(r, "CandidateGenerator");
        t.start();
    }

    private void runWork() {
        try {
            long number = 2;
            while ( true ) {
                while ( !outputFifo.add(number) ) {
                    Thread.sleep(100);
                }

                number++ ;
            }
        } catch ( InterruptedException x ) {
            // ignore and let the thread die
        }
    }
}
