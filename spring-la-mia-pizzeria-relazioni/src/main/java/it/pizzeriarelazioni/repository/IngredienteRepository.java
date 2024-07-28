package it.pizzeriarelazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeriarelazioni.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
	
}