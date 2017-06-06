package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRemRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.GradeService;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EntrepriseRepository entreprep;
	@Autowired
	private ProfilRemRepository profils;
	@Autowired
	private GradeService grades;
	@Autowired
	private RemunerationEmployeRepository rememp;
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("remunerations", rememp.findAll());
		return mv;
	}	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {

		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprise", entreprep.findAll());
		mv.addObject("grades",grades.lister());
		mv.addObject("profils",profils.findAll());
		return mv;
	}
	
	@RequestMapping(value ="/creer", method = RequestMethod.POST)
	public String form(Model model, @RequestParam(name="matricule") String matricule, @RequestParam(name="entreprise") Integer entreprise, @RequestParam(name="profil") Integer profil, @RequestParam(name="grade") Integer grade) {
	RemunerationEmploye employe =new RemunerationEmploye(ZonedDateTime.now(), matricule, entreprep.findOne(entreprise), profils.findOne(profil), grades.findbyId(grade));
	rememp.saveAndFlush(employe);
	return "redirect:/mvc/employes/lister";
	}
	

}
