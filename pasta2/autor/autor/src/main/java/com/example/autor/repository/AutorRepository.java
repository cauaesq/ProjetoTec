package com.example.autor.repository;

import com.example.autor.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}