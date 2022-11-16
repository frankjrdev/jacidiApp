package com.jacidi.asignacion;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableJSONDoc
@SpringBootApplication()
public class AsignacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsignacionApplication.class, args);
	}

}
