package com.iu.home.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.transaction.annotation.Transactional;

import com.iu.home.board.qna.Pager;
import com.iu.home.board.qna.QnaMapper;
import com.iu.home.board.qna.QnaVO;

@SpringBootTest
//@Rollback(true)
@Transactional
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QnaMapper qnaMapper;
	
	@BeforeAll
	static void befoAll() {
		System.out.println("전체 Test 실행 전🤗");
	}
	@AfterAll
	static void afterAll() {
		System.out.println("전체 Test 실행 후😘");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Test 메서드 실행 전🐶");
		QnaVO qnaVO = new QnaVO();
		qnaVO.setNum(1L);
		qnaVO.setContents("contents");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Test 메서드 실행 후🙈");
	}
	
	//@Test
	void test2() {
		log.info("Test2 Case");
//		qnaMapper.setUpdate(qnaVO);
//		qnaMapper.setDelete(qnaVO);
	}
	
	//@Test
	void test(Pager pager)throws Exception {
		List<QnaVO> ar = qnaMapper.getList(pager);
		log.info("List {}", ar);
		assertNotEquals(0, ar.size());
	}
	
	@Test
	//@Rollback(false) 트랜잭션 영향을 받지않고 롤백이 실행되지 않는다.
	void setAdd()throws Exception {
		for(int i = 0; i < 1; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setWriter("서리");
			qnaVO.setTitle("그랬구나");
			qnaVO.setContents("ㅎㅎ..");
			int result = qnaMapper.setAdd(qnaVO);			
			log.info("확인 {}", qnaVO);
			assertEquals(1, result);
		}
		
	}

}
