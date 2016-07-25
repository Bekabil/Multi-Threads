package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class CandidateGenerator is written and provided by my instructor.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CircularArrayLongFifo. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
 * *************************************************************************************
 */
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
            outputFifo.add(2);
            long number = 3;
            while ( true ) {
                outputFifo.add(number);
                number += 2;
            }
        } catch ( InterruptedException x ) {
            // ignore and let the thread die
        }
    }
}
