package com.defect.manager.domain.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.defect.manager.domain.entity.Defects;
import com.defect.manager.domain.entity.User;

import lombok.Getter;

@Getter
public class DefectsResponseDto {

	private Long no;
	
	private String roomType;
	private String content;
	
	private String createdDate;
	private String modifiedDate;
	
	private User user;
	
	
	public DefectsResponseDto(Defects entity) {
		this.no = entity.getNo();
		this.roomType = entity.getRoomType();
		this.content = entity.getContent();
		this.user = entity.getUser();
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
