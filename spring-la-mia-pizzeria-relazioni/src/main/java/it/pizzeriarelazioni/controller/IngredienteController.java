package it.pizzeriarelazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.pizzeriarelazioni.model.Ingrediente;
import it.pizzeriarelazioni.model.Pizza;
import it.pizzeriarelazioni.repository.IngredienteRepository;
import jakarta.validation.Valid;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteRepository repositoryIngrediente;
	
	
	@GetMapping("/listaIngredienti")
	public String listaIngredienti(Model model, @RequestParam(name = "name", required = false) String name) {
		
		model.addAttribute("listIngredienti", repositoryIngrediente.findAll());
		
		return "listaIngredienti";
	}
	
	
	@GetMapping("/listaIngredienti/insert-ingrediente")
	public String aggiungiIngrediente(Model model) {
		
	    model.addAttribute("formIngrediente", new Ingrediente());
	    
	    return "insert-ingrediente"; 
	}
	
	
	@PostMapping("/listaIngredienti/insert-ingrediente")
	public String storeIngrediente( @Valid @ModelAttribute("formIngrediente") Ingrediente formIngrediente, BindingResult bindingResult, Model model){
		
	   if(bindingResult.hasErrors()) {
	      return "insert-ingrediente";
	   }

	   repositoryIngrediente.save(formIngrediente);

	   return "redirect:/listaIngredienti";
	}
	
	@PostMapping("/listaIngredienti/delete/{id}")
	public String deleteIngrediente(@PathVariable("id") Integer id) {
		
		repositoryIngrediente.deleteById(id);
		
		return "redirect:/listaIngredienti";
	}
	
	
}
