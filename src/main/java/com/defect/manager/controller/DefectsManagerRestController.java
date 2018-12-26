package com.defect.manager.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.defect.manager.domain.dto.DefectsRequestDto;
import com.defect.manager.domain.entity.Defects;
import com.defect.manager.service.DefectsManageService;

import lombok.AllArgsConstructor;


/**
https://meetup.toast.com/posts/92

1) URI는 정보의 자원을 표현해야 한다. (리소스명은 동사보다는 명사를 사용)
GET /members/delete/1 => X (잘못된 예)

2) 자원에 대한 행위는 HTTP Method(GET, POST, PUT, DELETE 등)로 표현
DELETE /members/1

1) 슬래시 구분자(/)는 계층 관계를 나타내는 데 사용
2) URI 마지막 문자로 슬래시(/)를 포함하지 않는다.
3) 하이픈(-)은 URI 가독성을 높이는데 사용
4) 밑줄(_)은 URI에 사용하지 않는다.
5) URI 경로에는 소문자가 적합하다.
6) 파일 확장자는 URI에 포함시키지 않는다.
 */


@RestController
@AllArgsConstructor
public class DefectsManagerRestController {
	
	private DefectsManageService defectsManageService;
//
	//get - 하자목록 1건 불러오기
	@GetMapping("/defects/{no}")
	public @ResponseBody Defects getDefectsList(@PathVariable Long no) {
		/**
		 * JSON객체로 return하기  : https://blog.hanumoka.net/2018/04/29/spring-20180429-spring-controller-return-json/
		 */
		return defectsManageService.getDefectsByNo(no);
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
