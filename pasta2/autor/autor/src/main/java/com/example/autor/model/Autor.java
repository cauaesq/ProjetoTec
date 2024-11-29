package com.example.autor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data; 


@Data
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "A nacionalidade não pode estar vazia")
    private String nacionalidade;

	public Object getNome() {
	
		return null;
	}

	public Object getNacionalidade() {
		return null;
	}

	public void setNome(Object nome2) {
		
	}

	public void setNacionalidade(Object nacionalidade2) {
		
	}
}

