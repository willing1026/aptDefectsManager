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

/**
 * Entity 생성시 주의점
 * https://jojoldu.tistory.com/16
 * 
Entity 클래스를 생성하실때, 주의하실것은 무분별한 setter 메소드 생성입니다. 
자바빈 규약을 생각하시면서 getter/setter를 무작정 생성하시는 분들이 계시는데요. 
이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확히 구분할수가 없어, 차후 기능변경시 정말 복잡해집니다. 
해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가하셔야만 합니다.
 *
잘못된 사용
public class Order{
    public void setStatus(boolean status){
        this.status = status
    }
}

public void 주문서비스의_취소메소드 (){
   order.setStatus(false);
}

올바른 사용
public class Order{
    public void cancelOrder(){
        this.status = false;
    }
}
public void 주문서비스의_취소메소드 (){
   order.cancelOrder();
}
 *
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
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
	private String roomType;
	
	@Column(length=1000, nullable=false)
	private String content;

	@Builder
	public Defects(String userId, String aptCd, String roomType, String content) {
		this.userId = userId;
		this.aptCd = aptCd;
		this.roomType = roomType;
		this.content = content;
	}
	
	//게시글 내용수정
	public void fixDefects(String roomType, String content) {
		this.roomType = roomType;
		this.content = content;
	}
	
}