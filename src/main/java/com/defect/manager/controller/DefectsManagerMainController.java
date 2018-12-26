package com.defect.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.defect.manager.service.DefectsManageService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DefectsManagerMainController {

	private DefectsManageService defectsManageService;

	//get - 하자목록 불러오기
	//thymeleaf 사용위해서 pom.xml에 dependency 추가 필요
	@GetMapping("/")
	public String getDefectsList(Model model) {
		model.addAttribute("defectsList", defectsManageService.getDefectsList());
		return "main";
	}
	
}
