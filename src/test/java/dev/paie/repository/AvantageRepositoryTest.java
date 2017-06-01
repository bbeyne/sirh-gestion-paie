package dev.paie.repository;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouvel avantage
	Avantage avantage = new Avantage("NAT", "Nature", new BigDecimal("69.00"));
	avantageRepository.save(avantage);

	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	avantageRepository.findOne(avantage.getId());
	// TODO modifier un avantage
	avantage.setCode("Pat");
	avantage.setMontant(new BigDecimal("10.00"));
	avantage.setNom("Pature");
	avantageRepository.save(avantage);
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	avantageRepository.findOne(avantage.getId());
	avantageRepository.findByCode("NAT");
}

}