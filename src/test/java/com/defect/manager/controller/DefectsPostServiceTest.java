package com.defect.manager.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.defect.manager.domain.dto.DefectsRequestDto;
import com.defect.manager.domain.entity.Defects;
import com.defect.manager.domain.repository.DefectsRepository;
import com.defect.manager.service.DefectsManageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefectsPostServiceTest {

	@Autowired
	private DefectsManageService defectsManageService;
	
	@Autowired
	private DefectsRepository defectsRepository;
	
	@Test
	public void postTest() {
//		DefectsRequestDto dto = new DefectsRequestDto("paycis", "APT-203-4302", "거실", "벽지");
//		defectsManageService.postDefects(dto);
//		
//		List<Defects> defectsLists = defectsRepository.findAll();
//		Defects defects = defectsLists.get(0); 
//		
//		assertThat(defects.getAptCd()).isEqualTo(dto.getAptCd());
//		assertThat(defects.getContent()).isEqualTo(dto.getContent());
//		assertThat(defects.getRoomType()).isEqualTo(dto.getRoomType());
//		assertThat(defects.getUserId()).isEqualTo(dto.getUserId());
		
		
	}
}
