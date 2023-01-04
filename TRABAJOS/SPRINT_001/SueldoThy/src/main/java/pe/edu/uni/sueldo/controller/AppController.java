package pe.edu.uni.sueldo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pe.edu.uni.sueldo.model.SueldoModel;
import pe.edu.uni.sueldo.service.SueldoService;

@Controller
public class AppController {

	@Autowired
	private SueldoService sueldoService;

	@GetMapping({ "/", "/home" })
	public String inicio(Model model) {
		model.addAttribute("control", 1);
		return "index";
	}

	@PostMapping("/procesar")
	public String procesar(SueldoModel sueldoModel, Model model) {
		sueldoModel = sueldoService.procesar(sueldoModel);

		model.addAttribute("control", 2);
		model.addAttribute("bean", sueldoModel);
		return "index";
	}
}
