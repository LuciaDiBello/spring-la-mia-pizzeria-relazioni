package it.pizzeriarelazioni.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate; 

@Entity
@Table(name = "OfferteSpeciali")
public class Offerta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "La data di inizio non può essere null")
	@Column(name = "DataInizio", nullable = false)
	private LocalDate dataInizio;
	
	@NotNull(message = "La data di fine non può essere null")
	@Column(name = "DataFine", nullable = false)
	private LocalDate dataFine;
	
    	@NotBlank(message = "Il titolo non può essere null")
	@NotNull(message = "Il titolo non può essere null")
	private String titolo;
	
	@ManyToOne
	@JoinColumn(name = "PizzaRif", nullable = false)
	private Pizza pizza;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
}