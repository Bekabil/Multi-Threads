package com.abc.prime;
/***************************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Assignment: Homework 05, prime numbers generator.
 * Date: February 17, 2016
 * Instructor: Paul Hyde Program:
 ***************************************************************************************
 * This base class NanoTimer is written and provided by my instructor.
 * This program works along with other classes, LongFifo, PrimMani, PrimeChecker, CandidateGenerator, and
 * CircularArrayLongFifo. This program generates prime numbers and store them in a circular
 * array. This program is implemented using the concept of FIFO data structure.
 * The purpose of this program is to learn the functionality of wait() and
 * notifyAll() functions while adding and removing primary numbers to and from FIFO
 * *************************************************************************************
 */
public class NanoTimer {
    private final double NS_PER_MILLISECOND = 1000000.0;
    private final double NS_PER_SECOND = NS_PER_MILLISECOND * 1000.0;
    private final double NS_PER_MINUTE = NS_PER_SECOND * 60.0;
    private final double NS_PER_HOUR = NS_PER_MINUTE * 60.0;
    private final double NS_PER_DAY = NS_PER_HOUR * 24.0;

    private long nsStartTimeOfInterval;
    private long nsTotalOfStoppedIntervals = 0L;
    private boolean paused = true;

    // private, use createXYZ methods
    private NanoTimer() {
    }

    public static NanoTimer createStarted() {
        NanoTimer timer = new NanoTimer();
        timer.start();
        return timer;
    }

    public static NanoTimer createStopped() {
        return new NanoTimer();
    }

    public synchronized void start() {
        if ( paused ) {
            paused = false;
            nsStartTimeOfInterval = System.nanoTime();
        }
    }

    public synchronized void stop() {
        if ( !paused ) {
            paused = true;
            nsTotalOfStoppedIntervals += System.nanoTime() - nsStartTimeOfInterval;
        }
    }

    public synchronized void reset() {
        stop();
        nsTotalOfStoppedIntervals = 0L;
    }

    public synchronized long getElapsedNanoseconds() {
        return nsTotalOfStoppedIntervals +
            (paused ? 0 : System.nanoTime() - nsStartTimeOfInterval);
    }

    public double getElapsedMilliseconds() {
        return getElapsedNanoseconds() / NS_PER_MILLISECOND;
    }

    public double getElapsedSeconds() {
        return getElapsedNanoseconds() / NS_PER_SECOND;
    }

    public double getElapsedMinutes() {
        return getElapsedNanoseconds() / NS_PER_MINUTE;
    }

    public double getElapsedHours() {
        return getElapsedNanoseconds() / NS_PER_HOUR;
    }

    public double getElapsedDays() {
        return getElapsedNanoseconds() / NS_PER_DAY;
    }
}
