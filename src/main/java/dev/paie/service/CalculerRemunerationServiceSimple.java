package dev.paie.service;


import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{
	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		res.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase())));
		res.setSalaireBrut(paieUtils.formaterBigDecimal(bulletin.getPrimeExceptionnelle().add(new BigDecimal(res.getSalaireDeBase()))));
		
		BigDecimal sum= new BigDecimal("0");
		sum=bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(c->c.getTauxPatronal() != null)
				.map(c->c.getTauxPatronal())
				.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
		res.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(sum.multiply(new BigDecimal(res.getSalaireBrut()))));
		
		
		sum = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().stream()
				.filter(c->c.getTauxSalarial() != null)
				.map(c->c.getTauxSalarial())
				.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
		res.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(sum.multiply(new BigDecimal(res.getSalaireBrut()))));
		
		sum = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
				.filter(c->c.getTauxSalarial() != null)
				.map(c->c.getTauxSalarial())
				.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
		res.setNetImposable(paieUtils.formaterBigDecimal((new BigDecimal(res.getSalaireBrut())).subtract(new BigDecimal(res.getTotalRetenueSalarial()))));
		res.setNetAPayer(paieUtils.formaterBigDecimal((new BigDecimal(res.getNetImposable())).subtract(sum.multiply(new BigDecimal(res.getSalaireBrut())))));
		return res;
	}
}
