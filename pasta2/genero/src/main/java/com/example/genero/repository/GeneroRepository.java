package com.example.genero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.genero.model.*;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}