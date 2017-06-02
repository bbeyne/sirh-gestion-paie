package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@ComponentScan("dev.paie.service")
@ComponentScan("dev.paie.util")
@ImportResource("classpath:jdd-config.xml")
@Import({DataSourceMySQLConfig.class,JpaConfig.class})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

}
