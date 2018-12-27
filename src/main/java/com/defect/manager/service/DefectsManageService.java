package com.defect.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.defect.manager.domain.dto.DefectsRequestDto;
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
	
//	@Transactional(readOnly=true) //안써도 됨
//	public Defects getDefectsByNo(Long no) {
//		return defectsRepository.findByNo(no);
//	}
	
	//post
	@Transactional
	public Long postDefects(DefectsRequestDto dto) {
		return defectsRepository.save(dto.toEntity()).getNo();
	}
	
	//put
	@Transactional 
	public void updateDefects(Long no, DefectsRequestDto dto) {
		Defects defects = defectsRepository.findByNo(no);
		
		defects.fixDefects(dto.getRoomType(), dto.getContent());
		
		defectsRepository.save(defects);
	}
	
	//delete
	//TODO - 나중에 list로 변경하기
	@Transactional
	public void deleteDefects(Long no) {
		defectsRepository.deleteById(no);
	}
}
