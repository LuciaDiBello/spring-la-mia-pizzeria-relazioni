package it.pizzeriarelazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeriarelazioni.model.Offerta;

public interface OffertaRepository extends JpaRepository<Offerta, Integer> {

}