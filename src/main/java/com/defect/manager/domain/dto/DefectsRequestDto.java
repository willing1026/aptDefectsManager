package com.defect.manager.domain.dto;

import com.defect.manager.domain.entity.Defects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DefectsRequestDto {

	private String userId;
	private String aptCd;
	private String roomCd;
	private String content;
	
	public Defects toEntity() {
		return Defects.builder()
					.userId(userId)
					.aptCd(aptCd)
					.roomCd(roomCd)
					.content(content)
					.build();
	}
	
	@Builder
	public DefectsRequestDto(String userId, String aptCd, String roomCd, String content) {
		this.userId = userId;
		this.aptCd = aptCd;
		this.roomCd = roomCd;
		this.content = content;
	}
}
