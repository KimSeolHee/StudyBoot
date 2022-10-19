package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {

	@Autowired
	public QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		return qnaMapper.getList(pager);
	}
}
