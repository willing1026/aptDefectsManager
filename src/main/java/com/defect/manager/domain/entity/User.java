package com.defect.manager.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String aptCd;
	
	@Builder
	public User(String email, String password, String aptCd) {
		this.email = email;
		this.password = password;
		this.aptCd = aptCd;
	}
	
//	@Column
//	@OneToOne(fetch=FetchType.LAZY)
//	private Apt apt;

//	@Builder
//	public User(Long idx, String email, String password, Apt apt) {
//		this.idx = idx;
//		this.email = email;
//		this.password = password;
//		this.apt = apt;
//	}
}
