package Java_Collection.Main_task.Cars;
import Java_Collection.Main_task.Models.*;

public class Car implements Comparable<Car> {
    private int carId;
    private String licensePlate;
    private int fuelCapacity;
    private int fuelConsumption;
    private double price;
    private int maxSpeed;
    private int yearOfIssue;
    private CarMake carMake;
    private TypeOfBody typeOfBody;

    public Car(int carId, String licensePlate, int fuelCapacity, int fuelConsumption,
               double price, int maxSpeed, int yearOfIssue, CarMake carMake, TypeOfBody typeOfBody){
        this.carId= carId;
        this.licensePlate = licensePlate;
        this.fuelCapacity= fuelCapacity;
        this.fuelConsumption=fuelConsumption;
        this.price = price;
        this.maxSpeed =maxSpeed;
        this.yearOfIssue = yearOfIssue;
        this.carMake= carMake;
        this.typeOfBody=typeOfBody;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public void setCarMake(CarMake carMake) {
        this.carMake = carMake;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", licensePlate='" + licensePlate + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                ", yearOfIssue=" + yearOfIssue +
                ", carMake=" + carMake +
                ", typeOfBody=" + typeOfBody +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (carId != car.carId) return false;
        if (fuelCapacity != car.fuelCapacity) return false;
        if (fuelConsumption != car.fuelConsumption) return false;
        if (Double.compare(car.price, price) != 0) return false;
        if (maxSpeed != car.maxSpeed) return false;
        if (yearOfIssue != car.yearOfIssue) return false;
        if (licensePlate != null ? !licensePlate.equals(car.licensePlate) : car.licensePlate != null) return false;
        if (carMake != car.carMake) return false;
        return typeOfBody == car.typeOfBody;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = carId;
        result = 31 * result + (licensePlate != null ? licensePlate.hashCode() : 0);
        result = 31 * result + fuelCapacity;
        result = 31 * result + fuelConsumption;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + maxSpeed;
        result = 31 * result + yearOfIssue;
        result = 31 * result + (carMake != null ? carMake.hashCode() : 0);
        result = 31 * result + (typeOfBody != null ? typeOfBody.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Car o) {
        int result = fuelConsumption - o.fuelConsumption;
        int value = 0;
        if(fuelConsumption - o.fuelConsumption>0) {
            return 1;
        }
        if(fuelConsumption - o.fuelConsumption<0){
            return -1;
        }
        else return 0;
    }
}