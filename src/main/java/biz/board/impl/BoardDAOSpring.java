package biz.board.impl;

import biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BoardDAOSpring {
    // SQL 명령어
    private final String BOARD_INSERT = "insert into BOARD(SEQ, TITLE, WRITER, CONTENT) values((select IFNULL(max(SEQ), 0)+1 from BOARD ALIAS_FOR_SUBQUERY),?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set TITLE=?, CONTENT=? where SEQ=?";
    private final String BOARD_DELETE = "delete BOARD where SEQ=?";
    private final String BOARD_GET = "select * from BOARD where SEQ=?";
    private final String BOARD_LIST = "select * from BOARD order by SEQ desc";
    private final String BOARD_LIST_T = "select * from BOARD where TITLE like '%'||?||'%' order by SEQ desc";
    private final String BOARD_LIST_C = "select * from BOARD where CONTENT like '%'||?||'%' order by SEQ desc";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CRUD
    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
        jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
        jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
    }

    // 글 상세조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
        Object[] args = {vo.getSeq()};
        // 단건일때 queryForObject()를 사용
        return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
        Object[] args = {vo.getSearchKeyword()};
        if (vo.getSearchCondition().equals("TITLE")) {
            return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
        } else if (vo.getSearchCondition().equals("CONTENT")) {
            return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
        }
        return null;
    }
}
