package com.Ep3.Cliente.controller;

import com.Ep3.Cliente.entity.Persona;
import com.Ep3.Cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

	@Autowired(required=true)
	private ClienteService clienteService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", clienteService.getAll());
		return "index";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("persona", clienteService.get(id));
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		clienteService.save(persona);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		clienteService.delete(id);

		return "redirect:/";
	}

}