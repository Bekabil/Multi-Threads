/**************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Date: February 1, 2016
 * Instructor: Paul Hyde Program:
 ****************************************************************************
 * This class Fruit is written as a self-running object. This class Fruit starts up an internal thread
 * when its constructor is invoked. Some codes and comments are taken from chapter 11 of Java Thread
 * Programming.
 * *****************************************************************************
 */
package com.abc.fruit;

public class Fruit extends Object implements Runnable {
    private String name;
    private Thread internalThread;
    private volatile boolean noStopRequested;
    private volatile int count;

    /**
     * constructor Fruit
     *
     * @param name
     */
    public Fruit(String name) {
        super();
        this.name = name;
        // initializing appear here first.
        System.out.println("construction in progress for " + this.name + " fruit...");
        System.out.println();
        // just before returning, the thread should be
        // created and started
        count = 1;
        noStopRequested = true;
        internalThread = new Thread(this);
        internalThread.start();
    }
    /**
     * run() method
     */
    @Override
    public void run() {

        // check that no one has erroneously invoked
        // this public method
        if ( Thread.currentThread() != internalThread ) {
            throw new RuntimeException("only the internal "
                + "thread is allowed to invoke run() ");
        }
        try {
            // Repeat the following as long as noStopRequested is true
            // and count is less than and equal to 20
            while ( noStopRequested && count <= 20 ) {
                // print this Fruit's name 20 times
                System.out
                    .println("This fruit is: " + this.name + "\t" + count);
                count++ ;
                // internal Thread sleeps for 700 ms.
                Thread.sleep(700);

            }
        } catch ( InterruptedException x ) {
            // any caught interrupts should be habitually
            // reasserted for any blocking statements
            // which follow.

            Thread.currentThread().interrupt();
        }

    }

    /**
     * method stopRequest()
     */
    public void stopRequest() {
        noStopRequested = false;
        internalThread.interrupt();
    }

    /**
     * method isAlive()
     *
     * @return
     */
    public boolean isAlive() {
        return internalThread.isAlive();
    }

}
