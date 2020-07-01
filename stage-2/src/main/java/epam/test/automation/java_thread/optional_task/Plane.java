package epam.test.automation.java_thread.optional_task;

import java.util.concurrent.Semaphore;

public class Plane extends Thread {
    Semaphore semaphore;
    String name;

    Plane(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(name + " went to  the runway");
            sleep(3000);
            System.out.println(name + " took off");
            System.out.println("Runway got plane " + name);
            System.out.println("Runway is clear");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
