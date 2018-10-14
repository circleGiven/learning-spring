package biz.board.impl;

import biz.board.BoardVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet resultSet, int i) throws SQLException {
        BoardVO vo = new BoardVO();
        vo.setSeq(resultSet.getInt("SEQ"));
        vo.setTitle(resultSet.getString("TITLE"));
        vo.setWriter(resultSet.getString("WRITER"));
        vo.setContent(resultSet.getString("CONTENT"));
        vo.setRegDate(resultSet.getDate("REGDATE"));
        vo.setCnt(resultSet.getInt("CNT"));
        return vo;
    }
}
