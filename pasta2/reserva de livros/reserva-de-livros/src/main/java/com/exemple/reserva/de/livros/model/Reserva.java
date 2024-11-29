package com.exemple.reserva.de.livros.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define que a classe é uma entidade JPA
@Table(name = "reservas") // Nome da tabela no banco de dados
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    @Column(nullable = false) // Define uma coluna no banco
    private String nomeUsuario;

    @Column(nullable = false)
    private String nomeLivro;

    private boolean confirmada;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

	public void setDataReserva(LocalDate now) {
		
	}

	public void setDataDevolucao(LocalDate plusDays) {
		
	}

	public void setNomeLivro(Livro livro) {
		
		
	}
}