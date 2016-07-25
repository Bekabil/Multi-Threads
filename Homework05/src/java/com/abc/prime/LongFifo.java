package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class LongFifo is written and provided by my instructor.
 * This program works along with other classes, CandidateGenerator, PrimMani, PrimeChecker, and
 * CircularArrayLongFifo. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
 * *************************************************************************************
 */
public interface LongFifo {
    /** Returns the number if items currently in the FIFO. */
    int getCount();

    /** Returns true if {@link #getCount()} == 0. */
    boolean isEmpty();

    /** Returns true if {@link #getCount()} == {@link #getCapacity()}. */
    boolean isFull();

    /** Removes any and all items in the FIFO leaving it in an empty state. */
    void clear();

    /**
     * Returns the maximum number of items which can be stored in this FIFO.
     * This value never changes.
     */
    int getCapacity();

    /**
     * Add the specified item to the fifo.
     * If currently full, the calling thread waits until there is space and
     * then adds the item.
     * If this method doesn't throw InterruptedException, then the item was
     * successfully added.
     */
    void add(long value) throws InterruptedException;

    /**
     * Removes and returns the next item.
     * If currently empty, the calling thread waits until another thread adds
     * an item.
     * If this method doesn't throw InterruptedException, then the item was
     * successfully removed.
     */
    long remove() throws InterruptedException;

    /**
     * Returns a reference to use for synchronized blocks which need to
     * call multiple methods without other threads being able to get in.
     * Never returns null.
     */
    Object getLockObject();
}
