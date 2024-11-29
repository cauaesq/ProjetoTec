package com.example.autor.controller;

import com.example.autor.model.*;
import com.example.autor.service.*;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return service.getAllAutores();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Long id) {
        return service.getAutorById(id);
    }

    @PostMapping
    public Autor createAutor(@Valid @RequestBody Autor autor) {
        return service.saveAutor(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return service.updateAutor(id, autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        service.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}