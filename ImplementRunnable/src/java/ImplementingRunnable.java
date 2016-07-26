/**
 * @author Bekabil Tolassa
 *
 * This program is written to learn about multi-threading by implementing Runnable interface.
 */
public class ImplementingRunnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());

        t1.start();
        t2.start();
    }

}

class Runner implements Runnable{

    @Override
    public void run() {
        runWork();
    }

    private void runWork() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello World from ImplementingRunnable class. Thread name " + Thread.currentThread().getName() + i);
            try {
               Thread.sleep(100);
           } catch ( InterruptedException x ) {
               x.printStackTrace();
           }
        }
    }

}