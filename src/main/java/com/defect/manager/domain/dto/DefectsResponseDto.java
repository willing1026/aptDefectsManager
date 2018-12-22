package com.defect.manager.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.defect.manager.domain.entity.Defects;

import lombok.Getter;

@Getter
public class DefectsResponseDto {

	private Long no;
	
	private String userId;
	private String aptCd;
	private String roomCd;
	private String content;
	
	private String createdDate;
	private String modifiedDate;
	
	
	public DefectsResponseDto(Defects entity) {
		this.no = entity.getNo();
		this.userId = entity.getUserId();
		this.aptCd = entity.getAptCd();
		this.roomCd = entity.getRoomCd();
		this.content = entity.getContent();
		this.createdDate = toStringDateTime(entity.getCreatedDate());
		this.modifiedDate = toStringDateTime(entity.getModifiedDate());
	}
	
	public String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format)
				.orElse("");
	}
	
}
