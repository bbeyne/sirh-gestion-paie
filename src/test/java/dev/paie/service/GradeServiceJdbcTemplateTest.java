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
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class})
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired 
	private GradeService gradeService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade gradetest = new Grade();
		gradetest.setCode("grade2");
		gradetest.setId(2);
		gradetest.setNbHeuresBase(new BigDecimal("35.00"));
		gradetest.setTauxBase(new BigDecimal("9.80"));
		gradeService.sauvegarder(gradetest);
		

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		assertThat(gradeService.lister().get(gradeService.lister().size()-1).getId(), equalTo(gradetest.getId()));
		assertThat(gradeService.lister().get(gradeService.lister().size()-1).getCode(), equalTo(gradetest.getCode()));
		assertThat(gradeService.lister().get(gradeService.lister().size()-1).getNbHeuresBase(), equalTo(gradetest.getNbHeuresBase()));
		assertThat(gradeService.lister().get(gradeService.lister().size()-1).getTauxBase(), equalTo(gradetest.getTauxBase()));
		
		
		// TODO modifier un grade
		gradetest.setCode("grade 2");
		gradeService.mettreAJour(gradetest);

		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		Grade grade= gradeService.lister().stream().filter(c->c.getId()==gradetest.getId()).findFirst().get();
		assertThat(grade.getId(), equalTo(gradetest.getId()));
		assertThat(grade.getCode(), equalTo(gradetest.getCode()));
		assertThat(grade.getNbHeuresBase(), equalTo(gradetest.getNbHeuresBase()));
		assertThat(grade.getTauxBase(), equalTo(gradetest.getTauxBase()));
		
	}
}
