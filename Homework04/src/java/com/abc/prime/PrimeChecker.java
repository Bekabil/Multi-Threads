/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, prime numbers generator.
 * Date: February 15, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class PrimeChecker is written and provided by my instructor.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * *************************************************************************************
 */
package com.abc.prime;

import com.abc.prime.LongFifo.RemoveResult;

public class PrimeChecker {
    private final LongFifo inputFifo;
    private final LongFifo outputFifo;

    public PrimeChecker(LongFifo inputFifo, LongFifo outputFifo) {
        this.inputFifo = inputFifo;
        this.outputFifo = outputFifo;

        new Thread(new Runnable() {
            @Override
            public void run() {
                runWork();
            }
        }, "PrimeChecker").start();
    }

    private void runWork() {
        try {
            while ( true ) {
                RemoveResult rr = null;
                while ( ! (rr = inputFifo.remove()).isValid() ) {
                    Thread.sleep(10);
                }

                if ( isPrime(rr.getValue()) ) {
                    while ( !outputFifo.add(rr.getValue()) ) {
                        Thread.sleep(10);
                    }
                }
            }
        } catch ( InterruptedException x ) {
            // ignore and let the thread die
        }
    }

    private boolean isPrime(long number) {
        for ( long divisor = 2; divisor < number; divisor++ ) {
            if ( number % divisor == 0 ) {
                return false;
            }
        }
        return true;
    }
}
