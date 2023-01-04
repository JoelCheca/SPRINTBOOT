package pe.edu.uni.clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import pe.edu.uni.clinica.model.ClinicaModel;
import pe.edu.uni.clinica.model.ComboModel;
import pe.edu.uni.clinica.service.ClinicaService;



	;


@Controller
public class AppController {
	
	
	
	@Autowired
	private ClinicaService comisionService;
	

	@GetMapping({"/","/home"})
	public String inicio(Model model) {
		model.addAttribute("control", 1);
		return "index";
	}
	
	
	
	@PostMapping("/procesar")
	public String procesar(@ModelAttribute ClinicaModel clinicaModel, Model model) {
		// Proceso
		clinicaModel = comisionService.procesar(clinicaModel);
		// Reporte	
		model.addAttribute("control", 2);
		model.addAttribute("bean", clinicaModel);
		return "index";
	}
	
	
	
	
	
		
	@ModelAttribute
	private void cargarCombos(Model model) {
		List<ComboModel> servicio = new ArrayList();
		servicio.add(new ComboModel(0,"SELECCIONAR"));
		servicio.add(new ComboModel(1,"Consulta Ambulatoria"));
		servicio.add(new ComboModel(2,"Consulta Emergencia"));
		servicio.add(new ComboModel(3,"Medicina Genérica"));
		servicio.add(new ComboModel(4,"Medicina de marca"));
		servicio.add(new ComboModel(5,"Medicina oncologica"));
		servicio.add(new ComboModel(6,"Laboratorio"));	
		servicio.add(new ComboModel(7,"Otros"));	
		model.addAttribute("servicio",servicio);
		
		
		
	}
}
