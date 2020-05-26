package Java_Collection.Main_task;

import java.util.ArrayList;
import java.util.Collections;
import Java_Collection.Main_task.Models.*;
import Java_Collection.Main_task.Cars.*;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new PassengerCar(701,"6534 AK", 68, 12, 4,
                12000.34, 145, 2010, CarMake.KIA, TypeOfBody.HATCHBACK));
        cars.add(new PassengerCar(306,"2323 BA", 50, 8, 4,
                6700.33, 180, 2017, CarMake.VOLKSWAGEN, TypeOfBody.SEDAN ));
        cars.add(new PassengerCar(505,"6324 EB", 80,13,6,
                21000.00,180,2019, CarMake.VOLVO, TypeOfBody.MINIVAN));
        cars.add(new FreightTransport(3434, "4343 EA", 77, 16,
                5, 3, 34000.23, 120, 2012, CarMake.RENAULT,
                TypeOfBody.LORRY));
        cars.add(new FreightTransport(9090, "1234 EA", 100, 20,
                12, 5, 56000.07, 90, 2015, CarMake.MAN,
                TypeOfBody.LORRY));
        cars.add(new FreightTransport(7676, "9009 EC", 120, 23,
                10, 12, 85003.00, 110, 2006, CarMake.VOLVO,
                TypeOfBody.LORRY));
        Collections.sort(cars);
        TaxiGarage taxiGarage = new TaxiGarage(cars);
        System.out.println(cars);
        System.out.println(taxiGarage.findPriceAllCars());
        System.out.println(taxiGarage.findCarBySpeed(120,180));

    }
}