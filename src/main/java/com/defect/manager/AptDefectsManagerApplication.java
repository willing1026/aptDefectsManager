package com.defect.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/** 이거 안해주면 createdDate, modifiedData 안들어감  */
@EnableJpaAuditing

@SpringBootApplication
public class AptDefectsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AptDefectsManagerApplication.class, args);
	}

}

