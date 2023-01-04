package pe.edu.uni.comision.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.uni.comision.model.ComboModel;
import pe.edu.uni.comision.model.ComisionModel;
import pe.edu.uni.comision.service.ComisionService;

	;


@Controller
public class AppController {
	
	@Autowired
	private ComisionService comisionService;
	

	@GetMapping({"/","/home"})
	public String inicio(Model model) {
		model.addAttribute("control", 1);
		return "index";
	}
	
	

	@PostMapping("/procesar")
	public String procesar(@ModelAttribute ComisionModel comisionModel, Model model) {
		// Proceso
		comisionModel = comisionService.procesar(comisionModel);
		// Reporte	
		model.addAttribute("control", 2);
		model.addAttribute("bean", comisionModel);
		return "index";
	}
	
	
	
	
	
		
	@ModelAttribute
	private void cargarCombos(Model model) {
		List<ComboModel> cat = new ArrayList();
		cat.add(new ComboModel(0,"SELECCIONAR"));
		cat.add(new ComboModel(1,"1.PROGRAMACIÓN"));
		cat.add(new ComboModel(2,"2.OFIMÁTICA"));
		cat.add(new ComboModel(3,"3.ADMINISTRACIÓN"));
		cat.add(new ComboModel(4,"4.OTROS"));	
		model.addAttribute("cat",cat);
		
		
		
	}
}
