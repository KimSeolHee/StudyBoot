package com.iu.home.board.qna;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long perPage = 10L;
	private Long startRow;
	
	public void makeRow() {
		this.startRow = (this.page-1)*perPage;
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return this.page;
	}
	
}
