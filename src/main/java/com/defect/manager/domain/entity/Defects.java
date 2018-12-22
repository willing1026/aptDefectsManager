package com.defect.manager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Defects extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable=false)
	private String userId;
	
	@Column(nullable=false)
	private String aptCd;
	
	@Column(nullable=false)
	private String roomCd;
	
	@Column(length=1000, nullable=false)
	private String content;

	@Builder
	public Defects(String userId, String aptCd, String roomCd, String content) {
		this.userId = userId;
		this.aptCd = aptCd;
		this.roomCd = roomCd;
		this.content = content;
	}
	
}