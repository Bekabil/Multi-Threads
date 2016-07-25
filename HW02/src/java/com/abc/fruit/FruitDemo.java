/*********************************************************************************
 * Name: Bekabil Tolassa
 * Class: ICS 440
 * Date: February 1, 2016
 * Instructor: Paul Hyde Program:
 * *********************************************************************************
 * This class FruitDemo is written to create four instances of Fruit objects, each with different name.
 * Some codes and comments are taken from chapter 11 of Java Thread Programming
 * ******************************************************************************
 */
package com.abc.fruit;

public class FruitDemo extends Object {
    /**
     * main() method. The program starts here.
     *
     * @param args
     */
    public static void main(String[] args) {

        Fruit apple = new Fruit("Apple");
        Fruit avocado = new Fruit("Avocado");
        Fruit mango = new Fruit("Mango");
        Fruit orange = new Fruit("Orange");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException x ) {
            //in case of interrupt exception, interrupt() method is invoked on
            //the current Thread
            Thread.currentThread().interrupt();
            //stopRequest() method is invoked on each Fruit object
            mango.stopRequest();
            apple.stopRequest();
            orange.stopRequest();
            avocado.stopRequest();
        }
    }

}
