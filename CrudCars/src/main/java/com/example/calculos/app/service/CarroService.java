package com.example.calculos.app.service;


import com.example.calculos.app.entity.Carro;
import com.example.calculos.app.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro) {

        this.carroRepository.save(carro);

        return "Carro salvo com sucesso!";
    }

    public Carro FindById(Long id) {

        Optional<Carro> carro = this.carroRepository.findById(id);

        return carro.get();
    }

    public Carro update(Long id, Carro newCar) {
        Carro carroExistente = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        carroExistente.setNome(newCar.getNome());
        carroExistente.setAnoFabricacao(newCar.getAnoFabricacao());
        carroExistente.setMarca(newCar.getMarca());
        carroExistente.setModelo(newCar.getModelo());

        return carroRepository.save(carroExistente);

    }

    public void delete(Long id) {

        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        carroRepository.delete(carro);
    }

}
