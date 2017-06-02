package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entreprep;
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("Entreprise", entreprep.findAll());
		entreprep.findOne(0).getDenomination();
		return mv;

	}

}
