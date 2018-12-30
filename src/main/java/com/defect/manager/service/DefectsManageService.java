package com.defect.manager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<DefectsResponseDto> getDefectsList() {
		
		//java7 version
//		List<Defects> list = defectsRepository.findAll();
//		List<DefectsResponseDto> responseList = new ArrayList<DefectsResponseDto>();
//		for(Defects iter : list) {
//			responseList.add(new DefectsResponseDto(iter));
//		}
//		
//		return responseList;
		
		//java8 version
		//stream 역할은? java7에서는 이거 for문 돌면서 list에 담고 했어야했는데,,,
//		return defectsRepository.findAll().stream()
//		.map(DefectsResponseDto::new).collect(Collectors.toList());
		
		return defectsRepository.findAllDesc()
				.map(DefectsResponseDto::new).collect(Collectors.toList());
		
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
