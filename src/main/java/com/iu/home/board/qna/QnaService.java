package com.iu.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.home.util.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService {

	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.qna}")
	private String path;
	
	public List<QnaVO> getList(Pager pager)throws Exception{
		return qnaMapper.getList(pager);
	}
	
	public int setAdd(QnaVO qnaVO)throws Exception{
		int result = qnaMapper.setAdd(qnaVO);
		
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
		}
		
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(f.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		return result;
	}
	
	public QnaVO getDetail(QnaVO qnaVO)throws Exception{
		qnaVO = qnaMapper.getDetail(qnaVO);
		return qnaVO;
	}
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO)throws Exception{
		return qnaMapper.getFileDetail(qnaFileVO);
	}
	
	public int setUpdate(QnaVO qnaVO)throws Exception{
		return qnaMapper.setUpdate(qnaVO);
	}
	
	public int setDelete(QnaFileVO qnaFileVO)throws Exception{
		return qnaMapper.setDelete(qnaFileVO);
	}
}
