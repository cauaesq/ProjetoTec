package com.example.autor.service;

import com.example.autor.model.*;
import com.example.autor.repository.*;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
	
	@Autowired
    private AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> getAllAutores() {
        return repository.findAll();
    }

    public Autor getAutorById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public Autor saveAutor(@Valid Autor autor) {
        return repository.save(autor);
    }

    public Autor updateAutor(Long id, Autor updatedAutor) {
        Autor existingAutor = getAutorById(id);
        existingAutor.setNome(updatedAutor.getNome());
        existingAutor.setNacionalidade(updatedAutor.getNacionalidade());
        return repository.save(existingAutor);
    }

    public void deleteAutor(Long id) {
        repository.deleteById(id);
    }
}