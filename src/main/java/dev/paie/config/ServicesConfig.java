package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@ComponentScan("dev.paie.service")
@ComponentScan("dev.paie.util")
@ImportResource("jdd-config.xml")
@Import(DataSourceMySQLConfig.class)
public class ServicesConfig {

}
