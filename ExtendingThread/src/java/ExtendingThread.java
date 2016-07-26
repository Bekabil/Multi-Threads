/**
 * @author Bekabil Tolassa
 *
 * This program is written to learn the basics of multi-threading by extending Thread class
 */
public class ExtendingThread {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();

        runner1.start();
        runner2.start();

    }

}

class Runner extends Thread {
     public void run() {
         for(int i = 0; i < 10; i++) {
             System.out.println("Hello World from ExtendingThread class. Thread name " + Thread.currentThread().getName() + i);
             try {
                Thread.sleep(100);
            } catch ( InterruptedException x ) {
                x.printStackTrace();
            }
         }
     }
}