package com.defect.manager.controller;

import java.util.HashMap;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.defect.manager.domain.dto.DefectsRequestDto;
import com.defect.manager.service.DefectsManageService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DefectsManagerMainController {
	
	private DefectsManageService defectsManageService;

	//get - 하자목록 불러오기
	@GetMapping("/")
	public String getDefectsList(Model model) {
		return "defectsLists";
	}
	
	//post - 하자목록 등록하기
	@PostMapping("/defects")
	public Long postDefects(@RequestBody DefectsRequestDto dto) {
		//service 호출하기
		return defectsManageService.postDefects(dto);
	}
	
	//put - 하자목록 수정하기
	@PutMapping("/defects/{no}")
	public void updateDefects(@PathVariable Long no, @RequestBody DefectsRequestDto dto) {
		defectsManageService.updateDefects(no, dto);
	}
	
	//delete - 하자목록 삭제하기
	/**
	 * http://wonwoo.ml/index.php/post/1834
	 * PathVariable는 파라미터를 URL 경로에 포함시키는 방법
	 */
	@DeleteMapping("/defects/{no}")
	public void deleteDefects(@PathVariable Long no) {
		defectsManageService.deleteDefects(no);
	}
	
}
