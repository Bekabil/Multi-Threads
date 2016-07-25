package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class PrimeChecker is written and provided by my instructor.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CircularArrayLongFifo. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
 * *************************************************************************************
 */
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
                long candidate = inputFifo.remove();
                if ( isPrime(candidate) ) {
                    outputFifo.add(candidate);
                }
            }
        } catch ( InterruptedException x ) {
            // ignore and let the thread die
        }
    }

    private boolean isPrime(long number) {
        if ( number < 2 ) {
            return false;
        }

        long divisorLimit = 1 + (long) Math.sqrt(number);
        for ( long divisor = 2; divisor < divisorLimit; divisor++ ) {
            if ( number % divisor == 0 ) {
                return false;
            }
        }
        return true;
    }
}
