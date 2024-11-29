package com.exemple.reserva.de.livros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Boolean reservado = false; // Indica se o livro está reservado

	public boolean getReservado() {
		
		return false;
	}

	public void setReservado(boolean b) {
		

	}
}