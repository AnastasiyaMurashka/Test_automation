package Java_Collection.Main_task;
import Java_Collection.Main_task.Models.*;
import Java_Collection.Main_task.Cars.*;

import java.util.ArrayList;

public class TaxiGarage {
    private ArrayList<Car> cars;
    public TaxiGarage(ArrayList<Car> cars){
        this.cars=cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
    public double findPriceAllCars() {
        ArrayList<Car> cars = this.cars;
        double priceAllCars = 0;
        for (Car car : cars) {
            priceAllCars += car.getPrice();
        }
        return priceAllCars;
    }
    public ArrayList<Car> findCarBySpeed(int speedFrom, int speedTill){
        ArrayList<Car> cars = this.cars;
        ArrayList<Car> carBySpead = new ArrayList<>();
        for(Car car: cars){
            if((car.getMaxSpeed()>=speedFrom)&& (car.getMaxSpeed()<=speedTill)){
                carBySpead.add(car);
            }
        }
        return carBySpead;
    }
}