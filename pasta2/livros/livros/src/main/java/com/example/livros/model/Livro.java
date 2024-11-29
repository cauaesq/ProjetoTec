package com.example.livros.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    public String titulo;
    public String autor;
    public String genero;
	
    public Object getTitulo() {
		
		return null;
	}
	public Object getAutor() {
		
		return null;
	}
	public Object getGenero() {
		
		return null;
	}
	public void setTitulo(Object titulo2) {
		
		
	}
	public void setAutor(Object autor2) {
		
		
	}
	public void setGenero(Object genero2) {
		
	}
}