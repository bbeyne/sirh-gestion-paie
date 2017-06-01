package dev.paie.service;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired 
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder une nouvelle cotisation
		Cotisation cotis = new Cotisation("SP17", "sp17", new BigDecimal("0.10"), new BigDecimal("0.20"));
		cotisationService.sauvegarder(cotis);

	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		assertThat(cotisationService.lister().get(cotisationService.lister().size()-1).getId(), equalTo(cotis.getId()));
		
	// TODO modifier une cotisation
		cotis.setLibelle("Sp17");
		cotisationService.mettreAJour(cotis);
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		Cotisation cotitest = cotisationService.lister().stream().filter(c->c.getId()==cotis.getId()).findFirst().get();
		assertThat(cotitest.getId(), equalTo(cotis.getId()));

	}
}
