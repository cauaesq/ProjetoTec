package com.example.reserva.de.livros.repository;

import com.exemple.reserva.de.livros.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
