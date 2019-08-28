package com.mvc.hello.model;

import java.util.List;

import com.mvc.hello.dto.MVCBoardDto;


public interface MVCBiz {

	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectone(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
}
