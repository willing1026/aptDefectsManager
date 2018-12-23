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
	private String roomType;
	private String content;
	
	public Defects toEntity() {
		return Defects.builder()
					.userId(userId)
					.aptCd(aptCd)
					.roomType(roomType)
					.content(content)
					.build();
	}
	
	@Builder
	public DefectsRequestDto(String userId, String aptCd, String roomType, String content) {
		this.userId = userId;
		this.aptCd = aptCd;
		this.roomType = roomType;
		this.content = content;
	}
}
