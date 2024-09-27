package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Board {
	
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 프로젝트에서 연결된 DB의 넘버링 전략을 따른다.
	private int id;  // 시퀀스 auto_increment
	
	@Column(nullable = false, length= 100)
	private String title;   
	
	@Lob  // 대용량데이터
	private String content;  // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0")
	private int count;  //조회수
    
	@ManyToOne(fetch = FetchType.EAGER)// Many = Board, One = User
	@ JoinColumn(name="userId")
	private User  user;  //DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수 있다.
	
	@OneToMany(mappedBy="board", fetch = FetchType.EAGER)  //mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 칼럼을 만들지 마세요
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
