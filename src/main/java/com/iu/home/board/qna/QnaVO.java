package com.iu.home.board.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class QnaVO {
	
	private Long num;
	@NotBlank
	private String title;
	private String writer;
	@NotBlank
	@Size(max = 30, min = 5)
	private String contents;
	private Long hit;
	private Date reg_date;
	private Long ref;
	private Long step;
	private Long depth;

	private MultipartFile [] files;
	private List<QnaFileVO> qnaFileVOs;
}
