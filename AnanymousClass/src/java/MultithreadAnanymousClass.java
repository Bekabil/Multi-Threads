/**
 * @author Bekabil Tolassa
 *
 * This program is written to learn about multi-threading using anonymous class
 */
public class MultithreadAnanymousClass {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                runWork();

            }

        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                runWork();

            }

        });
        t1.start();
        t2.start();

    }

    private static void runWork() {
        for ( int i = 0; i < 10; i++ ) {
            System.out.println("Hello World from Ananymous class. Thread name " + Thread.currentThread().getName() + i);
            try {
                Thread.sleep(100);
            } catch ( InterruptedException x ) {
                x.printStackTrace();
            }
        }
    }
}
