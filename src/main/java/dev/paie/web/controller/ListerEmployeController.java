package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employes")
public class ListerEmployeController {

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("prefixMatricule", "M00");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String ajoutEmploye() {
		return "creerEmploye";
	}
}
