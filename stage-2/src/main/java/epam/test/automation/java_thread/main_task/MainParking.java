package epam.test.automation.java_thread.main_task;

public class MainParking {
    public static void main(String[] args) {
        Parking parking = new Parking(3);

        for (int i = 0; i < 6; i++) {
            new Car(parking).start();
        }
    }
}
