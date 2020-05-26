package Java_Collection.Main_task.Cars;
import Java_Collection.Main_task.Models.*;

public class PassengerCar extends Car {
    private int maxPassengers;
    public PassengerCar(int carId, String licensePlate, int fuelCapacity, int fuelConsumption, int maxPassengers,
                        double price, int maxSpeed, int yearOfIssue, CarMake carMake, TypeOfBody typeOfBody){
        super(carId,licensePlate,fuelCapacity,fuelConsumption,price,maxSpeed,yearOfIssue,carMake,typeOfBody);
        this.maxPassengers=maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", maxPassengers=" +
                maxPassengers + +'}'+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        return maxPassengers == that.maxPassengers;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxPassengers;
        return result;
    }
}