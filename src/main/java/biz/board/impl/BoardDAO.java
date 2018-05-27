package biz.board.impl;


import biz.board.BoardVO;
import biz.board.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository("boardDAO")
public class BoardDAO {
    // JDBC
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL
    private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) VALUES((SELECT nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
    private final String BOARD_DELETE = "DELETE board WHERE seq=?";
    private final String BOARD_GET    = "SELECT * FROM board WHERE seq=?";
    private final String BOARD_LIST   = "SELECT * FROM board ORDER BY seq desc";

    // CRUD
    public void insertBoard(BoardVO vo) {
        System.out.println("JDBC --- insertBoard()");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getWriter());
            stmt.setString(3, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void updateBoard(BoardVO vo) {
        System.out.println("JDBC --- updateBoard()");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("JDBC --- deleteBoard()");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public BoardVO getBoard(BoardVO vo) {
        System.out.println("JDBC --- getBoard()");
        BoardVO board = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();

            if (rs.next()) {
                board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return board;
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("JDBC --- getBoard()");
        List<BoardVO> boardList = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setContent(rs.getString("CONTENT"));
                board.setRegDate(rs.getDate("REGDATE"));
                board.setCnt(rs.getInt("CNT"));

                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return boardList;
    }
}
