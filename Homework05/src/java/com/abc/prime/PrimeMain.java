package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class PrimeMain is written and provided by my instructor.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CircularArrayLongFifo. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
 * *************************************************************************************
 */
public class PrimeMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        LongFifo candidateFifo = new CircularArrayLongFifo(500000);
        LongFifo primeFifo = new CircularArrayLongFifo(100);

        System.out.println("loading up candidate fifo...");
        new CandidateGenerator(candidateFifo);
        while (!candidateFifo.isFull()) {
            try {
                Thread.sleep(200);
            } catch ( InterruptedException x ) {
                x.printStackTrace();
            }
        }
        System.out.println("DONE loading up candidate fifo...");

        new PrimeChecker(candidateFifo, primeFifo);
        //new PrimeChecker(candidateFifo, primeFifo);
        //new PrimeChecker(candidateFifo, primeFifo);

        new PrimePrinter(primeFifo);
    }
}
