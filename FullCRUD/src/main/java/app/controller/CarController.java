package app.controller;


import app.entity.Car;
import app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService carService;


    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Car car) {
        try {
            String message = this.carService.save(car);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Car car,@PathVariable Long id) {
        try {
            String message = this.carService.update(car, id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> delete (@PathVariable Long id) {
        try {
            String message = this.carService.delete(id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Car>> findAll (Car car) {
        try {
            List<Car> list = this.carService.findAll();
            return  new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        try {
            Car car = this.carService.findById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
