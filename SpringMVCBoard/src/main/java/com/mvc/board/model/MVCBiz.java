package com.mvc.board.model;

import java.util.List;

import org.springframework.stereotype.Service;

public interface MVCBiz {

	public List<MVCDto> selectList();
	public MVCDto selectone(int seq);
	public int insert(MVCDto dto);
	public int update(MVCDto dto);
	public int delete(int seq);
	
}
