package com.defect.manager.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.defect.manager.domain.entity.Defects;
import com.defect.manager.domain.entity.User;
import com.defect.manager.domain.repository.DefectsRepository;
import com.defect.manager.domain.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityMappingTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DefectsRepository defectsRepository;
	
	@Before
	public void init() {
		User user = userRepository.save(User.builder()
				.email("test@gmail.com")
				.password("test")
				.aptCd("apt1")
				.build());
		
		defectsRepository.save(Defects.builder()
				.roomType("room1")
				.content("content")
				.user(user)
				.build());
	}
	
	@Test
	public void 엔티티_등록_테스트() {
		User user = userRepository.findByEmail("test@gmail.com");
		assertThat(user.getAptCd()).isEqualTo("apt1");
		
		Defects defects = defectsRepository.findByUser(user);
		assertThat(defects.getContent()).isEqualTo("content");
		assertThat(defects.getUser()).isEqualTo(user);
	}
	
}
