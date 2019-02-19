package com.defect.manager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Apt extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private String aptCd;
	
	@Column
	private String aptName;

	@Builder
	public Apt(Long idx, String aptCd, String aptName) {
		this.idx = idx;
		this.aptCd = aptCd;
		this.aptName = aptName;
	}	
}