package com.defect.manager;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.defect.manager.domain.entity.Defects;
import com.defect.manager.domain.entity.User;
import com.defect.manager.domain.repository.DefectsRepository;
import com.defect.manager.domain.repository.UserRepository;


/**
 * maven build - war로 packaging하기
 */

/** 이거 안해주면 createdDate, modifiedData 안들어감  */
@EnableJpaAuditing

@SpringBootApplication
public class AptDefectsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AptDefectsManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, DefectsRepository defectsRepository) {
		return (args) -> {
			User user = userRepository.save(User.builder()
					.email("test@gmail.com")
					.password("test")
					.aptCd("APT1")
					.build());
			
			IntStream.rangeClosed(1, 200).forEach(index->
				defectsRepository.save(Defects.builder()
						.roomType("방1")
						.content("테스트"+index)
						.user(user)
						.build())
					);
		};
	}
}

