/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 03, prime numbers generator.
 * Date: February 15, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class CircularArrayLongFifo is written and provided by my instructor.
 * The implementation of some methods in this class is completed by me.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * *************************************************************************************
 */

/**
 * Implementation of {@link LongFifo} which uses a circular array internally.
 * <p>
 * Look at the documentation in LongFifo to see how the methods are supposed to
 * work.
 * <p>
 * The data is stored in the slots array. count is the number of items currently
 * in the FIFO. When the FIFO is not empty, head is the index of the next item
 * to remove. When the FIFO is not full, tail is the index of the next available
 * slot to use for an added item. Both head and tail need to jump to index 0
 * when they "increment" past the last valid index of slots (this is what makes
 * it circular).
 * <p>
 * See <a href="https://en.wikipedia.org/wiki/Circular_buffer">
 * Circular Buffer on Wikipedia</a> for more information.
 */
package com.abc.prime;

public class CircularArrayLongFifo implements LongFifo {
    // do not change any of these fields:
    private final long[] slots;
    private int head;
    private int tail;
    private int count;
    private final Object lockObject;

    // this constructor is correct as written - do not change
    public CircularArrayLongFifo(int fixedCapacity, Object proposedLockObject) {

        lockObject =
            proposedLockObject != null ? proposedLockObject : new Object();

        slots = new long[fixedCapacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    // this constructor is correct as written - do not change
    public CircularArrayLongFifo(int fixedCapacity) {
        this(fixedCapacity, null);
    }

    // this method is correct as written - do not change
    @Override
    public int getCount() {
        synchronized ( lockObject ) {
            return count;
        }
    }

    @Override
    public synchronized boolean isEmpty() {
        // FIXME
        synchronized ( lockObject ) {
            return (count == 0);
        }

    }

    @Override
    public boolean isFull() {
        // FIXME
        synchronized ( lockObject ) {
            return (count == slots.length);
        }
    }

    @Override
    public void clear() {
        // FIXME
        synchronized ( lockObject ) {
            tail = 0;
            head = 0;
            count = 0;
        }
    }

    @Override
    public int getCapacity() {
        // FIXME
        return (slots.length);
    }

    @Override
    public boolean add(long value) {
        // FIXME
        synchronized ( lockObject ) {
            if ( !isFull() ) {
                slots[tail] = value;
                tail = ( (tail + 1) % getCapacity());
                count++ ;
                return true;
            }
            return false;
        }
    }

    @Override
    public LongFifo.RemoveResult remove() {
        // FIXME
        synchronized ( lockObject ) {
            long temp = slots[head];

            LongFifo.RemoveResult result;
            if ( this.isEmpty() )
                result = new LongFifo.RemoveResult(false, 0);
            else {
                result = new LongFifo.RemoveResult(true, temp);

                head = ( (head + 1) % getCapacity());

                count-- ;

            }

            return result;
        }

    }

    // this method is correct as written - do not change
    @Override
    public Object getLockObject() {
        return lockObject;
    }
}
