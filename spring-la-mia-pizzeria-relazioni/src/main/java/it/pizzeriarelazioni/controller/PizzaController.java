package it.pizzeriarelazioni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import it.pizzeriarelazioni.model.Pizza;
import it.pizzeriarelazioni.repository.PizzaRepository;

@Controller
public class PizzaController {

	@Autowired
	private PizzaRepository repositoryPizza;
		
	 @GetMapping("/index")
	 public String pizzaByName(Model model, @RequestParam(name = "name", required = false) String name) {
		
		List<Pizza> listaPizze = new ArrayList<>();
		if(name == null || name.isBlank()) {
			listaPizze = repositoryPizza.findAll();
		} else {
			listaPizze = repositoryPizza.findByName(name);
		}
		model.addAttribute("list", listaPizze);
		return "index";
	}

	
	@GetMapping("/index/{id}")
	public String descrizionePizza(@PathVariable("id") int pizzaId, Model model) {
		
		model.addAttribute("pizza", repositoryPizza.getReferenceById(pizzaId));
	
		return "descrizionePizza";
	  }
	
	
	@GetMapping("/index/insert")
	public String aggiungiPizza(Model model) {
		
	    model.addAttribute("formPizza", new Pizza());
	    
	    return "insert"; 
	}
	
	
	@PostMapping("/index/insert")
	public String storePizza( @Valid @ModelAttribute("formPizza") Pizza formPizza, BindingResult bindingResult, Model model){
		
	   if(bindingResult.hasErrors()) {
	      return "insert";
	   }

	   repositoryPizza.save(formPizza);

	   return "redirect:/index";
	}
	
	@GetMapping("/index/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("formPizza", repositoryPizza.findById(id).get());
		
		return "edit";
	}
	
	
	@PostMapping("/index/edit/{id}")
	public String updatePizza( @Valid @ModelAttribute("formPizza") Pizza formPizza, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "edit";
		}
		
		repositoryPizza.save(formPizza);
		
		return "redirect:/index";
	}
	
	
	@PostMapping("/index/delete/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
		
		repositoryPizza.deleteById(id);
		
		return "redirect:/index";
	}
	
}
	

