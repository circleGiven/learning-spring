package biz.board.impl;

import biz.board.BoardVO;
import biz.util.SqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * DAO(Data Access Object)
 *
 * 데이터베이스 연동을 담당
 * CRUD 메서드가 구현
 */
public class BoardDAO {
    private SqlSession mybatis;

    public BoardDAO() {
        mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
    }

    // 글 생성
    public void insertBoard(BoardVO vo) {
        mybatis.insert("BoardDAO.insertBoard", vo);
        mybatis.commit();
    }

    // 글 수정
    public void updateBoard(BoardVO vo) {
        mybatis.update("BoardDAO.updateBoard", vo);
        mybatis.commit();
    }

    // 글 삭제
    public void deleteBoard(BoardVO vo) {
        mybatis.delete("BoardDAO.deleteBoard", vo);
        mybatis.commit();
    }

    // 글 조회
    public BoardVO getBoard(BoardVO vo) {
        return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
    }

    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo) {
        return mybatis.selectList(" BoardDAO.getBoardList", vo);
    }
}
