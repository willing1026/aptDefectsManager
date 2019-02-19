package com.defect.manager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.defect.manager.domain.dto.DefectsResponseDto;
import com.defect.manager.domain.entity.User;
import com.defect.manager.service.DefectsManageService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class DefectsManagerMainController {

	private DefectsManageService defectsManageService;

	//get - 하자목록 불러오기
	//thymeleaf 사용위해서 pom.xml에 dependency 추가 필요
	@GetMapping("/")
	public String getDefectsList(Model model) {
		//TODO : 회원기능 생기면 user기준으로 목록 불러오게 수정 필요 (현재는 회원 1명이라는 가정)
		
		List<DefectsResponseDto> resultList = defectsManageService.getDefectsList();
		User user = resultList.get(0).getUser();
		
		model.addAttribute("defectsList", resultList);
		model.addAttribute("user", user);
		return "main";
	}
}
