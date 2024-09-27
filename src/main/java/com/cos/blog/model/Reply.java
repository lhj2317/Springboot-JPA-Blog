package com.cos.blog.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
public class Reply {
	
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 프로젝트에서 연결된 DB의 넘버링 전략을 따른다.
	private int id;  // 시퀀스 auto_increment
	 	
	@Column(nullable= false, length=200)
	private String content;  // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.
	
	@ManyToOne
	@JoinColumn(name= "boardId")
	private Board board;

	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
