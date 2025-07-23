package com.smhrd.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.board.entity.UserEntity;

@Repository // 어노테이션 안써도 됨 --> extends JpaRepository를 해주어서!
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	// 1. 인터페이스 상속 받기
	// 인터베이스간 상속은 extends 키워드 사용
	
	// <> 제너릭 : 레퍼런스 타입만 가능 --> 객체 타입 지정(들어갈 수 있는 타입이 하나 밖에 없음)
	// -->기본 타입 8가지 사용 불가 --> Wrapper Class(기본타입을 레퍼런스 타입으로 사용할 수 있게 해주는 클래스)
	
	// T: entity(VO) 객체 --> class 파일로 구성 시 테이블 생성 (VO객체 생성후 어노테이션 얹기)
	// ID : entity 가 가지고 있는 pk 필드의 타입(@Id가 걸려있는 필드의 타입)
	
	// 메소드의 기능 (기본 내장 되어 있는 메소드 소개)
	
	// 1. save(entity) --> insert into entity(table) values(매개변수로 넣은 entity)
	// 2. delete(매개변수) --> delete from entity명 where pk명 = 매개변수
	// 3. findAll() --> select * from entity명
	// 4. findById(매개변수) --> select * from entity명 where id=매개변수
	// 5. 커스텀 메소드
	// 	예시 : select * from 테이블명 where userId = ? and pw =?  
	// 	★★★★★단어 사이가 이어질 시 무조건 카멜기법★★★★★
	// 	규칙 :  select는 find / where는 by / 컬럼명 작성 / and, or, order by 등 키워드 있을 시 모두 작성
	
	//	예시 문장 JPA로 하면 findByUserIdAndPw(매개변수, 매개변수)
	
	/*
	 * 6. existsBy컬럼명(매개변수) : 데이터 유무를 알려주는 함수
	 * --> select conunt ~ limit
	 * --> select * from 테이블 명 where 컬럼 = 매개변수
	 * 
	 * userId기 있는지 없는지
	 * existsByUserId라는 함수는 없음
	 * --> 커스텀으로 만들어야 함
	 * */
	boolean existsByUserId(String user_id);
	//user_id를 바탕으로 데이터가 존재하는지 유무를 알려주는 기능
	
	// 로그인 기능
	// Optional 객체 - npe(null pointer exception)을 피하기 위해 사용
	// null이 왔을 시 프로그램 종료의 위험을 막기 위해 -> 값이 없을 시 empty를 return
	// 결론 : 결과가 없을 때 null이 아니라 없다를 보여주기 위한 객체
	Optional<UserEntity> findByUserIdAndPw(String id, String pw);
	
	
	
}
