package epam.test.automation.java_thread.main_task;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private static int counter = 1;
    private int id;
    private int waitingTime;
    private Random random;
    private Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
        this.id = counter++;
        random = new Random();
        waitingTime = random.nextInt(10) + 5;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car №" + id + " has arrived to parking");
            System.out.println("Car №" + id + " try to park and can't wait more than " + waitingTime + " sec");
            TimeUnit.MILLISECONDS.sleep(random.nextInt(15) * 1000);
            if (parking.tryParkCar(waitingTime)) {
                int timeStand = random.nextInt(15) + 15;
                System.out.println("Car №" + id + " has parked for " + timeStand + " sec");
                TimeUnit.SECONDS.sleep(timeStand);
                System.out.println("Car № " + id + " has left parking");
                parking.leaveParking();
            } else {
                System.out.println("Car № " + id + " can't wait anymore");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", waitingTime=" + waitingTime +
                '}';
    }
}
