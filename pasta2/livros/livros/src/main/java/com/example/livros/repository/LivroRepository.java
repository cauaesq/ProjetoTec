package com.example.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.livros.model.*;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}