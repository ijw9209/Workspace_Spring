package com.mvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.dto.MVCBoardDto;

@Repository
public class MVCBoardDaoImpl implements MVCBoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MVCBoardDto> selectList() {
												//첫번째는 쿼리 , 두번째는 객체만들어서 바디
		List<MVCBoardDto> list = jdbcTemplate.query("SELECT * FROM MVCBOARD" , new RowMapper<MVCBoardDto>() {
				@Override
				public MVCBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					MVCBoardDto res = new MVCBoardDto();
					res.setSeq(rs.getInt("SEQ"));
					res.setTitle(rs.getString("TITLE"));
					res.setContent(rs.getString("CONTENT"));
					res.setWriter(rs.getString("WRITER"));
					res.setRegdate(rs.getDate("REGDATE"));
					
					return res;
				}
		});
		return list;
	}
	
	//QueryforObject
	@Override
	public MVCBoardDto selectone(int seq) {

		MVCBoardDto dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new RowMapper<MVCBoardDto>() {

			@Override
			public MVCBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MVCBoardDto res = new MVCBoardDto();
				res.setSeq(rs.getInt("SEQ"));
				res.setTitle(rs.getString("TITLE"));
				res.setContent(rs.getString("CONTENT"));
				res.setWriter(rs.getString("WRITER"));
				res.setRegdate(rs.getDate("REGDATE"));
				return res;
			}
			
		});
	
		
		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		
		int res = jdbcTemplate.update(INSERT_SQL, new Object[] {dto.getWriter(),dto.getTitle(),dto.getContent()});
		
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		
		int res = jdbcTemplate.update(UPDATE_SQL, new Object[] {dto.getTitle(),dto.getContent(),dto.getSeq()} );
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = jdbcTemplate.update(DELETE_SQL, new Object[] {seq});
		
		return res;
	}

	@Override
	public boolean multidelete(String[] seq) {
//		Connection con = getConnection();
//		
//		PreparedStatement pstm = null;
//		int[] cnt = null;
//		int res = 0;
//		
//		
//		try {
//			pstm = con.prepareStatement(DELETE_SQL);
//			for(int i = 0; i <seq.length; i++) {
//			
//			pstm.setString(1, seq[i]);
//			pstm.addBatch();
//			}
//			cnt = pstm.executeBatch();
//			
//			for(int i = 0; i < cnt.length; i++) {
//				if(cnt[i] == -2) {
//					res++;
//				}
//			}
//			if(res == seq.length) {
//				commit(con);
//			}else {
//				rollback(con);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstm);
//			close(con);
//		}
		
		return false;
	}

}
