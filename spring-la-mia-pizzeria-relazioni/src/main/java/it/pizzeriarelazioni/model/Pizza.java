package it.pizzeriarelazioni.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Pizze")
public class Pizza{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="name", nullable=false)
	@NotNull(message="name cannot be null")
	@NotBlank(message="name cannot be null")
	private String name;

	@Column(name="descrizione", nullable=true)
	@Size(min = 0, max = 150, message="massimo 150 caratteri")
	private String descrizione;

	@Column(name="foto", nullable=true)
	private String foto;

	@Column(name="prezzo", nullable=false)
	@Positive(message="inserire un numero maggiore di zero")
	private float prezzo;
	
	@OneToMany(mappedBy = "pizza")
	private List<Offerta> offerte;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public List<Offerta> getOfferte() {
		return offerte;
	}

	public void setOfferte(List<Offerta> offerte) {
		this.offerte = offerte;
	}
	
}

