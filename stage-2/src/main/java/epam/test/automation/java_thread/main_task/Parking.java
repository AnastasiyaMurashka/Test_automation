package epam.test.automation.java_thread.main_task;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private int numberOfPlaces;
    private Semaphore semaphore;

    public Parking(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
        semaphore = new Semaphore(numberOfPlaces);
    }

    public boolean tryParkCar(int waitingTime) throws InterruptedException {
        return semaphore.tryAcquire(waitingTime, TimeUnit.SECONDS);
    }

    public void leaveParking() {
        semaphore.release();
    }
}
