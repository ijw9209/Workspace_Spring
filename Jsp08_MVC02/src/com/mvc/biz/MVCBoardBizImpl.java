package com.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.MVCBoardDao;
import com.mvc.dto.MVCBoardDto;

@Service
public class MVCBoardBizImpl implements MVCBoardBiz {

	@Autowired
	private MVCBoardDao dao;
	
	@Override
	public List<MVCBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCBoardDto selectone(int seq) {
		// TODO Auto-generated method stub
		return dao.selectone(seq);
	}

	@Override
	public int insert(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

	@Override
	public boolean multidelete(String[] seq) {
		// TODO Auto-generated method stub
		return dao.multidelete(seq);
	}

}
