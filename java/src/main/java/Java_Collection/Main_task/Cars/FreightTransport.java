package Java_Collection.Main_task.Cars;
import Java_Collection.Main_task.Models.*;

public class FreightTransport extends Car {
    private double maxCarryingCapacity;
    private double maxLengthCargo;
    public FreightTransport(int carId, String licensePlate, int fuelCapacity, int fuelConsumption,
                            double maxCarryingCapacity, double maxLengthCargo,
                            double price, int maxSpeed, int yearOfIssue, CarMake carMake, TypeOfBody typeOfBody){
        super(carId,licensePlate,fuelCapacity,fuelConsumption,price,maxSpeed,yearOfIssue,carMake,typeOfBody);
        this.maxCarryingCapacity = maxCarryingCapacity;
        this.maxLengthCargo= maxLengthCargo;
    }

    public double getMaxCarryingCapacity() {
        return maxCarryingCapacity;
    }

    public void setMaxCarryingCapacity(double maxCarryingCapacity) {
        this.maxCarryingCapacity = maxCarryingCapacity;
    }

    public double getMaxLengthCargo() {
        return maxLengthCargo;
    }

    public void setMaxLengthCargo(double maxLengthCargo) {
        this.maxLengthCargo = maxLengthCargo;
    }
    @Override
    public String toString() {
        return super.toString().replace("}", ", maxCarryingCapacity=" + maxCarryingCapacity +
                "maxLengthCargo= "+maxLengthCargo +'}'+'\n');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FreightTransport that = (FreightTransport) o;

        if (Double.compare(that.maxCarryingCapacity, maxCarryingCapacity) != 0) return false;
        return Double.compare(that.maxLengthCargo, maxLengthCargo) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(maxCarryingCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxLengthCargo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}