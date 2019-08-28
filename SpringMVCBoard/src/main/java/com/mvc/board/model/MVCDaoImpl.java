package com.mvc.board.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class MVCDaoImpl implements MVCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MVCDto> selectList() {
		
		List<MVCDto> list = jdbcTemplate.query("SELECT * FROM MVCBOARD", new RowMapper<MVCDto>() {

			@Override
			public MVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				MVCDto res = new MVCDto();
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

	@Override
	public MVCDto selectone(int seq) {
		MVCDto dto = jdbcTemplate.queryForObject("SELECT * FROM MVCBOARD WHERE SEQ = ?", new Object[] {seq}, new myMapper());
		return dto;
	}			
	@Override
	public int insert(MVCDto dto) {

		int res = jdbcTemplate.update(INSERT_SQL, new Object[] {dto.getWriter() , dto.getTitle(), dto.getContent()});
		return res;
	}

	@Override
	public int update(MVCDto dto) {

		int res = jdbcTemplate.update(UPDATE_SQL, new Object[] {dto.getTitle(),dto.getContent(),dto.getSeq()} );
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = jdbcTemplate.update(DELETE_SQL, new Object[] {seq});
		
		return res;
	}

	public static final class myMapper implements RowMapper<MVCDto>{

		@Override
		public MVCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			MVCDto res = new MVCDto();
			res.setSeq(rs.getInt("SEQ"));
			res.setTitle(rs.getString("TITLE"));
			res.setContent(rs.getString("CONTENT"));
			res.setWriter(rs.getString("WRITER"));
			res.setRegdate(rs.getDate("REGDATE"));
			return res;
		}
	}
}
