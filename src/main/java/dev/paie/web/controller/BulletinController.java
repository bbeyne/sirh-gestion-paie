package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	private BulletinSalaireRepository bulletinrep;
	@Autowired
	private RemunerationEmployeRepository rememp;
	@Autowired
	private PeriodeRepository perrep;
	@Autowired
	private CalculerRemunerationService calcul;
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		 mv.addObject("bulletins", bulletinrep.findAll());
		 List<ResultatCalculRemuneration> a= new ArrayList<>();
		 for (BulletinSalaire bulletin : bulletinrep.findAll()){
			 a.add(calcul.calculer(bulletin));
		 }
		 mv.addObject("remun",a);
		return mv;
	}
	 @RequestMapping(method = RequestMethod.GET, path = "/creer")
	 public ModelAndView creerbulletin() {
	
	 ModelAndView mv = new ModelAndView();
	
	 mv.setViewName("bulletins/creerBulletin");
	 mv.addObject("employes", rememp.findAll());
	 mv.addObject("periodes",perrep.findAll());
	 return mv;
	 }
	
	 @RequestMapping(value ="/creer", method = RequestMethod.POST)
	 public String form(Model model, @RequestParam(name="employe") Integer employe,
	 @RequestParam(name="periode") Integer periode, @RequestParam(name="prime") String prime) {
	 BulletinSalaire bulletin =new BulletinSalaire(ZonedDateTime.now(), rememp.findOne(employe), perrep.findOne(periode), new BigDecimal(prime));
	 bulletinrep.saveAndFlush(bulletin);
	 return "redirect:/mvc/bulletins/lister";
	 }
	

}
