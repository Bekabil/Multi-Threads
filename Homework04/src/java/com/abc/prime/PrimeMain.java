package com.abc.prime;

/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, prime numbers generator.
 * Date: February 15, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class PrimeMain is written and provided by my instructor.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * *************************************************************************************
 */
public class PrimeMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        LongFifo candidateFifo = new CircularArrayLongFifo(50000);
        LongFifo primeFifo = new CircularArrayLongFifo(100);

        System.out.println("loading up candidate fifo...");
        new CandidateGenerator(candidateFifo);
        while ( !candidateFifo.isFull() ) {
            try {
                Thread.sleep(200);
            } catch ( InterruptedException x ) {
                x.printStackTrace();
            }
        }
        System.out.println("DONE loading up candidate fifo...");

        new PrimeChecker(candidateFifo, primeFifo);
        // new PrimeChecker(candidateFifo, primeFifo);
        // new PrimeChecker(candidateFifo, primeFifo);

        new PrimePrinter(primeFifo);
    }
}
