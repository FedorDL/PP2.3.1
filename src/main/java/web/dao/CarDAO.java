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

    public List<Car> getCarsByCount(int count) {
        if (count < 0) {
            count = 0;
        } else if (count > 5) {
            count = 5;
        }
        return cars.subList(0, count);
    }
}
