package com.example.calculos.app.controller;


import com.example.calculos.app.entity.Carro;
import com.example.calculos.app.repository.CarroRepository;
import com.example.calculos.app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private CarroRepository carroRepository;

    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Carro carro) {

        try {
            String mensagem = this.carroService.save(carro);
            return
                    new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error, parameters incorret", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public  ResponseEntity<Carro> findById(@PathVariable Long id) {

        try {

            Carro carro = this.carroService.FindById(id);
            return  new ResponseEntity<>(carro, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{id}")
    public  ResponseEntity<Carro> update (@PathVariable Long id, @RequestBody Carro newCarro) {

        try {
            Carro carroUpdate = carroService.update(id, newCarro);
            return ResponseEntity.ok(carroUpdate);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {

        try {
            carroService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


 }
