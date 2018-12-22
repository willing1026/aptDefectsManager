package com.defect.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defect.manager.domain.dto.DefectsRequestDto;
import com.defect.manager.domain.dto.DefectsResponseDto;
import com.defect.manager.domain.entity.Defects;
import com.defect.manager.domain.repository.DefectsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DefectsManageService {

	private DefectsRepository defectsRepository;
	
	//get
	@Transactional(readOnly=true)
	public List<Defects> getDefectsList() {
		return defectsRepository.findAll();
	}
	
	//post
	@Transactional
	public Long postDefects(DefectsRequestDto dto) {
		return defectsRepository.save(dto.toEntity()).getNo();
	}
	
	//put
	@Transactional 
	public void updateDefects(Long no, DefectsRequestDto dto) {
		Defects defects = defectsRepository.findByNo(no);
		
		defects.setAptCd(dto.getAptCd());
		defects.setContent(dto.getContent());
		defects.setRoomCd(dto.getRoomCd());
		
		
		defectsRepository.save(defects);
	}
	
	
	//delete
	@Transactional
	public void deleteDefects(Long no) {
		defectsRepository.deleteById(no);
	}
}
