package com.example.genero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.genero.model.*;
import com.example.genero.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public ResponseEntity<Genero> criarGenero(@RequestBody Genero genero) {
        if (genero.getNome() == null || genero.getNome().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Genero novoGenero = generoRepository.save(genero);
        return ResponseEntity.ok(novoGenero);
    }

    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }
}