package com.example.reserva.de.livros.repository;

import com.exemple.reserva.de.livros.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}