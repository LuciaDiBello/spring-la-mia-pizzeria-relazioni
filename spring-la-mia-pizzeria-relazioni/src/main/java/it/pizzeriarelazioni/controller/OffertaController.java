package it.pizzeriarelazioni.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import it.pizzeriarelazioni.model.Offerta;
import it.pizzeriarelazioni.model.Pizza;
import it.pizzeriarelazioni.repository.OffertaRepository;
import it.pizzeriarelazioni.repository.PizzaRepository;

@Controller
public class OffertaController {

	@Autowired
	private OffertaRepository repositOfferta;
	  
	@Autowired
	private PizzaRepository repositPizza;
	
		@GetMapping("/index/insert-offerta/{id}")
			public String insertOfferta(@PathVariable("id") Integer id, Model model) {
				
				Pizza pizza = repositPizza.findById(id).get();

				Offerta offertaForm = new Offerta();

				offertaForm.setDataInizio(LocalDate.now());

				offertaForm.setPizza(pizza);
				
				model.addAttribute("offertaForm", offertaForm);
				
				return "insert-offerta";
			}
	
	
	@PostMapping("/index/insert-offerta/{id}")
	public String storeOfferta(@Valid @ModelAttribute("offertaForm") Offerta offertaForm, BindingResult bindingResult, Model model, @PathVariable("id") int pizzaId) {
		
		if(bindingResult.hasErrors()) {
			return "insert-offerta";
		}
		
		repositOfferta.save(offertaForm);
		
		return "redirect:/index/" + offertaForm.getPizza().getId();
	}
	
	
	@GetMapping("/index/edit-offerta/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		Offerta offertaForm = repositOfferta.findById(id).get();
		
		model.addAttribute("offertaForm", offertaForm);
		
		return "edit-offerta";
	}
	
	@PostMapping("/index/edit-offerta/{id}")
	public String updateOfferta(@Valid @ModelAttribute("offertaForm") Offerta offertaForm, BindingResult bindingResult, Model model) {
			
		if(bindingResult.hasErrors()) {
			return "edit-offerta";
		}

		repositOfferta.save(offertaForm);
		
		return "redirect:/index";
	}
	
}
