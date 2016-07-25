package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class CircularArrayLongFifo is written and provided by my instructor.
 * The implementation of some methods in this class is completed by me.
 * Some codes that are used in this are taken from chapter 18 of Java Thread Programming.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, and
 * CandidateGenerator. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
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
 * See <a href="https://en.wikipedia.org/wiki/Circular_buffer">Circular Buffer
 * on Wikipedia</a> for more information.
 */
public class CircularArrayLongFifo implements LongFifo {
    // do not change any of these fields:
    private final long[] slots;
    private int head;
    private int tail;
    private int count;
    private final Object lockObject;

    // this constructor is correct as written - do not change
    public CircularArrayLongFifo(int fixedCapacity,
                                 Object proposedLockObject) {

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
    public boolean isEmpty() {
        synchronized ( lockObject ) {
            return count == 0;
        }
    }

    @Override
    public boolean isFull() {
        synchronized ( lockObject ) {
            return count == slots.length;
        }
    }

    @Override
    public void clear() {
        synchronized ( lockObject ) {
            // No need - just keep the old junk (harmless):
            // Arrays.fill(slots, 0);
            head = 0;
            tail = 0;
            count = 0;
        }
    }

    @Override
    public int getCapacity() {
        return slots.length;
    }


    @Override
    public void add(long value) throws InterruptedException {

        synchronized ( lockObject ) {
            while(isFull()) {
                lockObject.wait();
            }
                slots[tail] = value;
                tail = ( (tail + 1) % getCapacity());
                count++ ;
                lockObject.notifyAll();

        }
    }

    @Override
    public long remove() throws InterruptedException {

        synchronized ( lockObject ) {

            while(isEmpty()) {
                lockObject.wait();
            }
            long temp = slots[head];

            head = ( (head + 1) % getCapacity());
            count--;
            lockObject.notifyAll();

            return temp;
            }

        }

    // this method is correct as written - do not change
    @Override
    public Object getLockObject() {
        return lockObject;
    }
}
