package dev.paie.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.WebAppConfig;
import dev.paie.service.InitialiserDonneesServiceDev;

@ContextConfiguration(classes = { WebAppConfig.class})
@RunWith(SpringRunner.class)
public class GradeRepo {
	@Autowired
	private InitialiserDonneesServiceDev init;
	
	@Test
	public void test(){
		init.initialiser();
	}
	
}
