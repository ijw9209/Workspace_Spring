package com.mvc.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MVCBIZImpl implements MVCBiz {

	@Autowired
	private MVCDaoImpl dao;
	
	@Override
	public List<MVCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCDto selectone(int seq) {
		// TODO Auto-generated method stub
		return dao.selectone(seq);
	}

	@Override
	public int insert(MVCDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MVCDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

}
