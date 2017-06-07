package dev.paie.service;


import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.repository.UserRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired  
	private ApplicationContext context;
	@Autowired
	private GradeService gradeserv;
	@Autowired
	private CotisationService cotis;
	@Autowired
	private EntrepriseRepository entreprep;
	@Autowired
	private ProfilRemRepository profil;
	@Autowired
	private PeriodeRepository perioderep;
	@Autowired 
	private RemunerationEmployeRepository remrep;
	@Autowired 
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userrep;
	
	@Override
	@Transactional
	public void initialiser() {
		// TODO Auto-generated method stub
		List<Cotisation> cotis2 = new ArrayList<>();
		cotis2.addAll(context.getBeansOfType(Cotisation.class).values());
		cotis2.forEach(cot-> cotis.sauvegarder(cot));
		
		List<Entreprise> entreprises = new ArrayList<>();
		entreprises.addAll(context.getBeansOfType(Entreprise.class).values());
		entreprep.save(entreprises);
		
		List<Grade> grades = new ArrayList<>();
		grades.addAll(context.getBeansOfType(Grade.class).values());
		grades.forEach(grade->gradeserv.sauvegarder(grade));
		
		List<ProfilRemuneration> profils = new ArrayList<>();
		profils.addAll(context.getBeansOfType(ProfilRemuneration.class).values());
		profil.save(profils);
		remrep.save(new RemunerationEmploye(ZonedDateTime.now(),"Warsama", entreprises.get(1), profils.get(1), gradeserv.lister().get(1)));
		
		for (int i=1; i<13;i++){
		LocalDate localdate = LocalDate.of(LocalDate.now().getYear(), i, 1);
		perioderep.save(new Periode(localdate, localdate.with(TemporalAdjusters.lastDayOfMonth())));
		}
		userrep.save(new Utilisateur("bouh", this.passwordEncoder.encode("bouh"), true, ROLES.valueOf("ROLE_ADMINISTRATEUR")));
		userrep.save(new Utilisateur("warsama", this.passwordEncoder.encode("warsama"), true, ROLES.valueOf("ROLE_UTILISATEUR")));
	}
	
	
}
