package com.example.calculos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.calculos.app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
