package app.service;


import app.entity.Car;
import app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public String save(Car car) {
        this.carRepository.save(car);
        return "Car saved successfully";
    }

    public String update(Car car, Long id) {
        car.setId(id);
        this.carRepository.save(car);
        return "Car updated successfully!";
    }

    public  String delete (Long id) {
        this.carRepository.deleteById(id);
        return "Car deleted successfully!";
    }

    public List<Car> findAll () {
        List<Car> list = this.carRepository.findAll();
        return list;
    }

    public Car findById(Long id) {
        Car car = this.carRepository.findById(id).get();
        return car;
    }
}
