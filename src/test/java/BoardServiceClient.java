import biz.board.BoardVO;
import biz.board.impl.BoardDAO;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) throws SQLException {
        BoardDAO boardDAO = new BoardDAO();

        BoardVO vo = new BoardVO();
        vo.setTitle("mybatis 제목");
        vo.setWriter("최원준");
        vo.setContent("myBatis 내용입니다...");
        boardDAO.insertBoard(vo);

        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardVOList = boardDAO.getBoardList(vo);
        for (BoardVO board : boardVOList) {
            System.out.println("---> " + board.toString());
        }
    }
}
