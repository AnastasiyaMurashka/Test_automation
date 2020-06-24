package epam.test.automation.java_thread.optional_task;

import java.util.concurrent.Semaphore;

public class MainPlane {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i < 11; i++)
            new Plane(semaphore, "Plane " + i).start();
    }
}
