package biz.board.impl;

import biz.board.BoardVO;
import biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO(Data Access Object)
 *
 * 데이터베이스 연동을 담당
 * CRUD 메서드가 구현
 */
@Repository("boardDAO")
public class BoardDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL 명령어
    private final String BOARD_INSERT = "insert into BOARD(SEQ, TITLE, WRITER, CONTENT) values((select IFNULL(max(SEQ), 0)+1 from BOARD ALIAS_FOR_SUBQUERY),?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set TITLE=?, CONTENT=? where SEQ=?";
    private final String BOARD_DELETE = "delete BOARD where SEQ=?";
    private final String BOARD_GET    = "select * from BOARD where SEQ=?";
    private final String BOARD_LIST   = "select * from BOARD order by SEQ desc";

    // CRUD
    // 글 등록
    public void insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());
            // 쿼리 싪행
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());
            // 쿼리 싪행
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            // 쿼리 싪행
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // 글 상세조회
    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> JDBC로 getBoard() 기능 처리");

        BoardVO result = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();

            if (rs.next()) {
                result = new BoardVO();
                result.setSeq(rs.getInt("SEQ"));
                result.setTitle(rs.getString("TITLE"));
                result.setWriter(rs.getString("WRITER"));
                result.setContent(rs.getString("CONTENT"));
                result.setRegDate(rs.getDate("REGDATE"));
                result.setCnt(rs.getInt("CNT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return result;
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> JDBC로 getBoardList() 기능 처리");

        // result
        List<BoardVO> result = new ArrayList<BoardVO>();

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
                result.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }

        return result;
    }
}
