package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("BMW", "X5", 2021));
        cars.add(new Car("Audi", "A6", 2019));
        cars.add(new Car("Mercedes", "E200", 2022));
        cars.add(new Car("Kia", "K5", 2023));
    }

    @Override
    public List<Car> getCars(int count) {

        if (count >= cars.size()) {
            return cars;
        }

        return cars.subList(0, count);
    }
}
