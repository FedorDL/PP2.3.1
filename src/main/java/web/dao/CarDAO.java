package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int CARS_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT,"Ferrari", "235"));
        cars.add(new Car(++CARS_COUNT,"LADA", "NIVA"));
        cars.add(new Car(++CARS_COUNT,"Bugatti", "Chirocco"));
        cars.add(new Car(++CARS_COUNT,"BMW", "X5"));
        cars.add(new Car(++CARS_COUNT,"AUDI", "Q7"));
    }

    public List<Car> getCars() {
        return cars;
    }
}
