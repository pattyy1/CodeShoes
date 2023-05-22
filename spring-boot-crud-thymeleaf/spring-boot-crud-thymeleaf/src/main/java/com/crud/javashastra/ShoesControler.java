package com.crud.javashastra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.crud.javashastra.entity.Shoes;

import com.crud.javashastra.service.ShoesService;

@Controller
public class ShoesControler {
	@Autowired
	ShoesService service;

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("shoes", service.findallShoes());
		return "all-shoes";
	}

	@GetMapping("/add")
	public String lunchAddShoesPage(Model model) {
		model.addAttribute("shoes", new Shoes());
		return "add-shoes";
	}


	@PostMapping("/addshoes")
	public String createShoes(Shoes shoes) {
		service.addShoes(shoes);
		return "redirect:/";

	}
	@PostMapping("/login")
	public String createLogin(Shoes shoes) {
		service.addShoes(shoes);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("shoes", service.findShoesById(id));
		return "edit-shoes";

	}

	@PostMapping("/updateshoes")
	public String upadteShoes(Shoes shoes) {
		service.updateShoes(shoes);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteShoes(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/products")
	public String lunchAddProductPage(Model model) {
		model.addAttribute("shoes", new Shoes());
		return "products";
	

	}
	@GetMapping("/carousel")
	public String lunchProductPage(Model model) {
		model.addAttribute("shoes", new Shoes());
		return "carousel";
	

	}

}
