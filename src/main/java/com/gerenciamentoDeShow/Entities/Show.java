package com.gerenciamentoDeShow.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Informe o nome do artista!")
	private String artista;
	
	@NotNull(message = "Informe o valor do ingresso!")
	private int valor;
	
	@Min(value = 1,message = "O tempo mínimo de show é de 01:00h")
	@Max(value = 5, message = "O tempo máximo de show é de 05:00h")
	private int tempo;
	
	@Min(value = 18,message = "Idade mínima é de 18 anos!")
	@Max(value = 150, message = "Idade máxima permitida é 150 anos")
	private int idade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
